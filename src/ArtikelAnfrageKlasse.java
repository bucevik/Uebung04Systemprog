public class ArtikelAnfrageKlasse extends Thread {
    private Monitorklasse monitor;
    private Datenbankklasse datenbank;
    private int nummer;
    public ArtikelAnfrageKlasse(int nummer, Monitorklasse monitor,
                         Datenbankklasse datenbank) {
        this.monitor = monitor;
        this.datenbank = datenbank;
        this.nummer = nummer;
        start();
    }
    public void run() {
        monitor.anfrageAnfangen();
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        datenbank.anfrage(nummer);
        monitor.anfrageEnde();
    }
}