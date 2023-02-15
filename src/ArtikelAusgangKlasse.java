public class ArtikelAusgangKlasse extends Thread {
    private Monitorklasse monitor;
    private Datenbankklasse datenbank;
    private int nummer;
    private int anzahl;
    public ArtikelAusgangKlasse(Monitorklasse monitor,
                         Datenbankklasse datenbank, int nummer, int anzahl) {
        this.monitor = monitor;
        this.datenbank = datenbank;
        this.nummer = nummer;
        this.anzahl = anzahl;
        start();
    }
    public void run() {
        monitor.ausgangAnfangen();
        try {
            sleep(100);
            datenbank.ausgang(nummer, anzahl);
        } catch (Exception e) {
            System.err.println(e.getMessage() + "\n");
        }
        monitor.ausgangEnde();
    }
}
