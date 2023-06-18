public class Modulo extends Wyrazenie{

    @Override
    public int getWartosc() {
        return wartosc;
    }

    @Override
    public int wartosc(Blok higherBlok) {
        this.wylicz(higherBlok);
        return this.wartosc;
    }
    int wartosc;
    Wyrazenie w1;
    Wyrazenie w2;
    @Override
    public String toString() {
        return " (" + w1 + " % " + w2 +") ";
    }
    @Override
    public void wylicz(Blok higherBlok) {
        wartosc = w1.wartosc(higherBlok) % w2.wartosc(higherBlok);
    }
    Modulo(Wyrazenie w1, Wyrazenie w2){
        this.w1 = w1;
        this.w2 = w2;
    }

    public static Modulo of(Wyrazenie w1, Wyrazenie w2){
        return new Modulo (w1,w2);
    }
}
