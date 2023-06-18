public class Literal extends Wyrazenie{
    int wartosc;

    @Override
    public String toString() {
        return
                "" + wartosc +
                "";
    }

    @Override
    public int wartosc(Blok higherBlok){
        return wartosc;
    }
    public void wylicz(Blok higherBlok){
        return;
    }
    public Literal(int i){
        this.wartosc = i;
    }
    public static Wyrazenie of(int i){
        return new Literal(i);
    }
}
