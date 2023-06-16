abstract class Wyrazenie {
    protected Blok higherBlok;
    protected int wartosc;


    public int getWartosc() {
        return wartosc;
    }

    public int wartosc(Blok higherBlok) {
        this.wylicz(higherBlok);
        return this.wartosc;
    }
    abstract public void wylicz(Blok higherBlok);
}
