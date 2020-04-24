
package ohtu.kivipaperisakset;

public enum Siirto {
    KIVI("K"),
    PAPERI("P"),
    SAKSET("S");

    public final String label;

    private Siirto(String label) {
        this.label = label;
    }
}
