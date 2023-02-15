public class ArtikelEingangKlasse extends Thread {
    private Monitorklasse monitor;
    private Datenbankklasse datenbank;
    private int nummer;
    private int anzahl;

    public ArtikelEingangKlasse(Monitorklasse monitor,
                                Datenbankklasse datenbank, int nummer, int anzahl) {
        this.monitor = monitor;
        this.datenbank = datenbank;
        this.nummer = nummer;
        this.anzahl = anzahl;
        start();
    }

    public void run() {
        monitor.eingangAnfangen();
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        datenbank.eingang(nummer, anzahl);
        monitor.eingangEnde();
    }
}