public class Monitorklasse {
    Semaphor semaphor;
    Semaphor semaphor1;
    int anzahlWarten;
    int zaehlerAktivAnfrage;
    int zaehlerWartenAnfrage;
    int zaehlerAktivAusgang;
    int zaehlerWartenAusgang;
    int zaehlerAktivEingang;
    int zaehlerWartenEingang;
    Semaphor wartenAnfrage;
    Semaphor wartenAusgang;
    Semaphor wartenEingang;
    public Monitorklasse() {
        semaphor = new Semaphor(1);
        semaphor1 = new Semaphor(0);
        wartenAnfrage = new Semaphor(0);
        wartenAusgang = new Semaphor(0);
        wartenEingang = new Semaphor(0);
        anzahlWarten = 0;
        zaehlerAktivAnfrage = 0;
        zaehlerWartenAnfrage = 0;
        zaehlerAktivAusgang = 0;
        zaehlerWartenAusgang = 0;
        zaehlerAktivEingang = 0;
        zaehlerWartenEingang = 0;
    }
    private void betreteMonitor() {
        semaphor.p();
    }
    private void belegeMonitor() {
        System.out.println("Aktiv: Eingang: " + zaehlerAktivEingang +
                ", Ausgang: " + zaehlerAktivAusgang +
                ", Anfrage: " + zaehlerAktivAnfrage);
        System.out.println("Wartend: Eingang: " +
                zaehlerWartenEingang + ", Ausgang: " +
                zaehlerWartenAusgang + ", Anfrage: " + zaehlerWartenAnfrage);
        System.out.println();
        if (anzahlWarten > 0) {
            anzahlWarten--;
            semaphor1.v();
        } else {
            semaphor.v();
        }
    }
    public void anfrageAnfangen() {
        betreteMonitor();
        if (zaehlerAktivAnfrage == 5 || zaehlerAktivEingang > 0
                || zaehlerAktivAusgang > 0 || zaehlerWartenAusgang > 0) {
            zaehlerWartenAnfrage++;
            System.out.println("Anfrage in Warteschlange: ");
            belegeMonitor();
            wartenAnfrage.p();
            semaphor1.p();
        }
        zaehlerAktivAnfrage++;
        System.out.println("starte Anfrage: ");
        belegeMonitor();
    }
    public void anfrageEnde() {
        betreteMonitor();
        zaehlerAktivAnfrage--;
        if (zaehlerAktivAnfrage == 0) {
            if (zaehlerWartenAusgang > 0) {
                ausgangWecken();
            } else if (zaehlerWartenEingang > 0) {
                eingangZuWeckend();
            }
        } else {
            if (zaehlerWartenAnfrage > 0 && zaehlerWartenAusgang == 0) {
                anfrageWecken();
            }
        }
        System.out.println("ende Anfrage: ");
        belegeMonitor();
    }
    public void eingangAnfangen() {
        betreteMonitor();
        if (zaehlerAktivEingang == 3 || zaehlerAktivAnfrage > 0
                || zaehlerAktivAusgang > 0 || zaehlerWartenAusgang > 0
                || zaehlerWartenAnfrage > 0) {
            zaehlerWartenEingang++;
            System.out.println("Eingang in Warteschlange: ");
            belegeMonitor();
            wartenEingang.p();
            semaphor1.p();
        }
        zaehlerAktivEingang++;
        System.out.println("starte Eingang: ");
        belegeMonitor();
    }
    public void eingangEnde() {
        betreteMonitor();
        zaehlerAktivEingang--;
        if (zaehlerAktivEingang == 0) {
            if (zaehlerWartenAusgang > 0) {
                ausgangWecken();
            } else if (zaehlerWartenAnfrage > 0) {
                anfrageZuWeckend();
            }
        } else {
            if (zaehlerWartenEingang > 0 && zaehlerWartenAusgang == 0
                    && zaehlerWartenAnfrage == 0) {
                eingangWecken();
            }
        }
        System.out.println("ende Eingang: ");
        belegeMonitor();
    }
    public void ausgangAnfangen() {
        betreteMonitor();
        if (zaehlerAktivAusgang > 0 || zaehlerAktivEingang > 0
                || zaehlerAktivAnfrage > 0) {
            zaehlerWartenAusgang++;
            System.out.println("Ausgang in Warteschlange: ");
            belegeMonitor();
            wartenAusgang.p();
            semaphor1.p();
        }
        zaehlerAktivAusgang++;
        System.out.println("starte Ausgang: ");
        belegeMonitor();
    }
    public void ausgangEnde() {
        betreteMonitor();
        zaehlerAktivAusgang--;
        if (zaehlerAktivAusgang == 0) {
            if (zaehlerWartenAusgang > 0) {
                ausgangWecken();
            } else if (zaehlerWartenAnfrage > 0) {
                anfrageZuWeckend();
            } else if (zaehlerWartenEingang > 0) {
                eingangZuWeckend();
            }
        } else {
            if (zaehlerWartenAusgang > 0) {
                ausgangWecken();
            }
        }
        System.out.println("ende Ausgang: ");
        belegeMonitor();
    }
    private void ausgangWecken() {
        zaehlerWartenAusgang--;
        wartenAusgang.v();
        anzahlWarten++;
    }
    private void anfrageWecken() {
        zaehlerWartenAnfrage--;
        wartenAnfrage.v();
        anzahlWarten++;
    }
    private void eingangWecken() {
        zaehlerWartenEingang--;
        wartenEingang.v();
        anzahlWarten++;
    }
    private void anfrageZuWeckend() {
        int zuWeckend = zaehlerWartenAnfrage;
        if (zaehlerWartenAnfrage > 5) {
            zuWeckend = 5;
        }
        for (int i = 0; i < zuWeckend; i++) {
            anfrageWecken();
        }
    }
    private void eingangZuWeckend() {
        int zuWeckend = zaehlerWartenEingang;
        if (zaehlerWartenEingang > 3) {
            zuWeckend = 3;
        }
        for (int i = 0; i < zuWeckend; i++) {
            eingangWecken();
        }
    }
}