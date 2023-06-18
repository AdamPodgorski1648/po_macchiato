public class Dzielenie  extends Wyrazenie{

    int wartosc;

    @Override
    public int getWartosc() {
        return wartosc;
    }

    @Override
    public int wartosc(Blok higherBlok) {
        this.wylicz(higherBlok);
        return this.wartosc;
    }
    Wyrazenie w1;
    Wyrazenie w2;

    @Override
    public String toString() {
        return " (" + w1 + " / " + w2 +") ";
    }
    @Override
    public void wylicz(Blok higherBlok) {
        wartosc = w1.wartosc(higherBlok) / w2.wartosc(higherBlok);
    }

    public Dzielenie(Wyrazenie w1, Wyrazenie w2) {
        this.w1 = w1;
        this.w2 = w2;
    }
    public static Dzielenie of(Wyrazenie w1, Wyrazenie w2){
        return new Dzielenie (w1,w2);
    }
}
