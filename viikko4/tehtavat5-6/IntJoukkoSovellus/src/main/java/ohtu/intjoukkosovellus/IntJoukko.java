package ohtu.intjoukkosovellus;

public class IntJoukko {

    // aloitustalukon koko
    public static final int KAPASITEETTI = 5;
    // luotava uusi taulukko on näin paljon isompi kuin vanha
    public static final int OLETUSKASVATUS = 5;
    private static final int ZERO = 0;
    // Uusi taulukko on tämän verran vanhaa suurempi.
    private int kasvatuskoko;
    // Joukon luvut säilytetään taulukon alkupäässä. 
    private int[] luvut;
    // Tyhjässä joukossa alkioiden_määrä on nolla. 
    private int alkioidenLkm;

    public IntJoukko() {
        this(KAPASITEETTI);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < ZERO) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");
        }
        if (kasvatuskoko < ZERO) {
            throw new IndexOutOfBoundsException("kapasiteetti2");
        }
        luvut = new int[kapasiteetti];

        alkioidenLkm = ZERO;
        this.kasvatuskoko = kasvatuskoko;

    }

    private int indeksi(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean lisaa(int luku) {

        if (!kuuluu(luku)) {
            luvut[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm % luvut.length == 0) {
                int[] taulukko = luvut;
                luvut = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(taulukko, luvut);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == luvut[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int kohta = indeksi(luku);
        int apu;

        if (kohta != -1) {
            for (int j = kohta; j < alkioidenLkm - 1; j++) {
                apu = luvut[j];
                luvut[j] = luvut[j + 1];
                luvut[j + 1] = apu;
            }
            alkioidenLkm--;
            return true;
        }

        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < alkioidenLkm - 1; i++) {
            sb.append(luvut[i]);
            sb.append(", ");
        }
        if (alkioidenLkm > 0) {
            sb.append(luvut[alkioidenLkm - 1]);
        }
        sb.append("}");
        return sb.toString();
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = luvut[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] joukkoA = a.toIntArray();
        int[] joukkoB = b.toIntArray();
        for (int i = 0; i < joukkoA.length; i++) {
            yhdiste.lisaa(joukkoA[i]);
        }
        for (int i = 0; i < joukkoB.length; i++) {
            yhdiste.lisaa(joukkoB[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] joukkoA = a.toIntArray();
        
        for (int i : joukkoA) {
            if (b.kuuluu(i)) {
                leikkaus.lisaa(i);
            }
        }
        return leikkaus;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] joukkoA = a.toIntArray();
        int[] joukkoB = b.toIntArray();
        for (int i = 0; i < joukkoA.length; i++) {
            erotus.lisaa(joukkoA[i]);
        }
        for (int i = 0; i < joukkoB.length; i++) {
            erotus.poista(joukkoB[i]);
        }

        return erotus;
    }

}
