public class ZmiennaWyr extends Wyrazenie{
    Character c;
    int wartosc;
    public int getWartosc(){
        return this.wartosc;
    }
    @Override
    public String toString() {
        return " " + c + "";
    }
    @Override
    public void wylicz(Blok higherBlok) {
        this.wartosc = higherBlok.getZmienna(this.c).wartosc();
    }

    @Override
    public int wartosc(Blok higherBlok) {
        this.wylicz(higherBlok);
        return this.wartosc;
    }
    public ZmiennaWyr(char c) {
        this.c = new Character(c);
    }

    public static ZmiennaWyr named(char c){
        return new ZmiennaWyr(c);
    }
}
