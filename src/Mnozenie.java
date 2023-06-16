public class Mnozenie extends Wyrazenie {

    int wartosc;
    Wyrazenie w1;
    Wyrazenie w2;

    @Override
    public int wartosc(Blok higherBlok) {
        this.wylicz(higherBlok);
        return this.wartosc;
    }
    @Override
    public String toString() {
        return " (" + w1 + " * " + w2 +") ";
    }
    @Override
    public void wylicz(Blok higherBlok) {

        wartosc = w1.wartosc(higherBlok) * w2.wartosc(higherBlok);
    }

    public Mnozenie(Wyrazenie w1, Wyrazenie w2) {
        this.w1 = w1;
        this.w2 = w2;
    }

    @Override
    public int getWartosc() {
        return wartosc;
    }
}
