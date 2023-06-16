public class PrzypisanieWartosci extends Instrukcja{
    Character c;
    Wyrazenie w;
    PrzypisanieWartosci(Character c, Wyrazenie w){
        this.c = c;
        this.w = w;
    }

    @Override
    public void wykonaj(Blok blok) {
        super.wykonajDebug(this);
        if(Instrukcja.dbg.Flag == Debugv2.DebuggingFlag.exit) return;
        int wartosc = 0;
        try {
            wartosc = this.w.wartosc(blok);
        }
        catch(Exception e) {
            if (Instrukcja.dbg.Flag == Debugv2.DebuggingFlag.noDebug)
                throw new IllegalArgumentException("blad wyliczania wyrazenia");
            else
                System.out.println("blad wyliczania wyrazenia");
            return;
        }
        blok.getZmienna(c).przypisz(wartosc);
    }

    @Override
    public String toString() {
        return "PrzypisanieWartosci{" +
                "c=" + c +
                ", w=" + w +
                '}';
    }
}
