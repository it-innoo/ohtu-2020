package ohtu.verkkokauppa;

public class Viitegeneraattori implements IViiteGeneraattori {

    private static int seuraava;

    public Viitegeneraattori() {
        seuraava = 1;
    }

    @Override
    public int uusi() {
        return seuraava++;
    }
}
