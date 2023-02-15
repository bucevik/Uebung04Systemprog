public class Datenbankklasse {
    private Artikel[] artikel;
    public Datenbankklasse(int anzahl, int bestand) {
        artikel = new Artikel[anzahl];
        for (int i = 0; i < anzahl; i++) {
            artikel[i] = new Artikel(i, bestand);
        }
    }
    public void eingang(int nummer, int anzahl) {
        artikel[nummer].eingang(anzahl);
        System.out.println("folgender Artikel hinzugefügt: \n" + "Artikel "
                + nummer + ", Anzahl: " + anzahl + "\n");
    }
    public void ausgang(int nummer, int anzahl) throws Exception {
        if (anzahl > artikel[nummer].anfrage()) {
            throw new Exception("Es sind nicht genügend Artikel vorhanden!");
        } else {
            artikel[nummer].ausgang(anzahl);
        }
        System.out.println("folgender Artikel entfernt: \n" + "Artikel " +
                nummer + ", Anzahl: " + anzahl + "\n");
    }
    public void anfrage(int nummer) {
        System.out.println("Bestand: \n" + "Artikel: " + nummer + "\n" +
                "Anzahl: " +
                artikel[nummer].anfrage() + "\n");
    }
}