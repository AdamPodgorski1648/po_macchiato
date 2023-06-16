public class Zmienna {
    int wartosc;
    public void przypisz(int nowa_wartosc){
        this.wartosc = nowa_wartosc;
    }
    public int wartosc(){
        return wartosc;
    }

    Zmienna(int w){
        this.przypisz(w);
    }
}
// wyglada na skonczone
