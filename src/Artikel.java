public class Artikel {
    private int name;
    private int bestand;
    public Artikel(int name, int bestand) {
        this.name = name;
        this.bestand = bestand;
    }
    public void ausgang(int anzahl) {
        bestand = bestand - anzahl;
    }
    public void eingang(int anzahl) {
        bestand = bestand + anzahl;
    }
    public int anfrage() {
        return bestand;
    }
}
