public class Hauptklasse{
    public static void main(String[] args) {
        Hauptklasse testklasse = new Hauptklasse();
        testklasse.testfall5();
    }
    public void testfall1() {
        Monitorklasse m = new Monitorklasse();
        Datenbankklasse d = new Datenbankklasse(1, 0);
        for (int i = 0; i < 8; i++) {
            new ArtikelAnfrageKlasse(0, m, d);
        }
    }
    public void testfall2() {
        Monitorklasse m = new Monitorklasse();
        Datenbankklasse d = new Datenbankklasse(5, 0);
        for (int i = 0; i < 5; i++) {
            new ArtikelEingangKlasse(m, d, i, 1);
        }
    }
    public void testfall3() {
        Monitorklasse m = new Monitorklasse();
        Datenbankklasse d = new Datenbankklasse(1, 3);
        for (int i = 0; i < 4; i++) {
            new ArtikelAusgangKlasse(m, d, 0, 1);
        }
    }
    public void testfall4() {
        Monitorklasse m = new Monitorklasse();
        Datenbankklasse d = new Datenbankklasse(5, 2);
        for (int i = 0; i < 4; i++) {
            new ArtikelEingangKlasse(m, d, i, 2);
        }
        for (int k = 0; k < 5; k++) {
            new ArtikelAnfrageKlasse(k, m, d);
        }
        for (int t = 0; t < 4; t++) {
            new ArtikelAusgangKlasse(m, d, t, 2);
        }
    }
    public void testfall5() {
        Monitorklasse m = new Monitorklasse();
        Datenbankklasse d = new Datenbankklasse(5, 2);
        new ArtikelAusgangKlasse(m, d, 0, 3);
        for (int i = 0; i < 5; i++) {
            new ArtikelAnfrageKlasse(i, m, d);
        }
        new ArtikelAnfrageKlasse(0, m, d);
        for (
                int t = 0;
                t < 5; t++) {
            new ArtikelEingangKlasse(m, d, t, 1);
        }
        for (
                int t = 0;
                t < 5; t++) {
            new ArtikelAusgangKlasse(m, d, t, 3);
        }
        for (
                int s = 0;
                s < 5; s++) {
            new ArtikelAnfrageKlasse(s, m, d);
        }
    }
}









