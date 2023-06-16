import java.util.LinkedList;
import java.util.List;

public class Petla extends Instrukcja{
    Blok b;
    Character c;
    Wyrazenie w;
    List<Instrukcja> list;
    @Override
    public Instrukcja copy(){
        List<Instrukcja> listrep = new LinkedList<Instrukcja>();
        for(Instrukcja i: list) listrep.add(i.copy());
        return new Petla(this.c,this.w,listrep);
    }
    @Override
    public void wykonaj(Blok aktualnyBlok) throws ExceptionInstrukcji {
        super.wykonajDebug(this);
        if(Instrukcja.dbg.Flag == Debugv2.DebuggingFlag.exit) return;
        this.b = aktualnyBlok;
        int n;
        // czemu w kolejnej linijce n wychodzi = 0?????
        try {
            n = this.w.wartosc(this.b);
        }
        catch(Exception e){
            if(Instrukcja.dbg.Flag == Debugv2.DebuggingFlag.noDebug)
                throw new IllegalArgumentException("blad wyliczania wyrazenia");
            else
                System.out.println("blad wyliczania wyrazenia");
            return;
        }
        List<Deklaracja> listD = new LinkedList<Deklaracja>();
        for(int i = 0;i < n; i++){

            List<Instrukcja> listI = new LinkedList<Instrukcja>();
            for(Instrukcja ins: this.list) listI.add(ins.copy());
            listD.add(new Deklaracja(this.c,new Literal(i)));
            Blok bp = new Blok(listD, listI);
            try {
                bp.wykonaj(aktualnyBlok);
            }
            catch(Exception e){
                throw new ExceptionInstrukcji(this);
            }
            listD.remove(0);
        }
    }
    public Petla(Character c, Wyrazenie w, List<Instrukcja> list) {
        this.c = c;
        this.w = w;
        this.list = list;
    }

    @Override
    public String toString() {
        return "Petla{" +
                " " + c +
                ", od 0 do " + w +
                '}';
    }
}
