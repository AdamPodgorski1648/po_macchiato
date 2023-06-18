public class Print extends Instrukcja{
    // git
    private Wyrazenie wyraz;

    public static Print of(Wyrazenie w){
        return new Print(w);
    }
    @Override
    public void wykonaj(Blok higherblok) {
        super.wykonajDebug(this);
        if(Instrukcja.dbg.Flag == Debugv2.DebuggingFlag.exit) return;
        int s;
        try{
            s = wyraz.wartosc(higherblok);
        }
        catch(IllegalArgumentException e) {
            return;
        }
       System.out.println(s);
    }

    public Print(Wyrazenie w) {
        this.wyraz = w;
    }

    @Override
    public String toString() {
        return "Print{" +
                "wyraz=" + wyraz +
                '}';
    }
}
