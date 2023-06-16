import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// na razie git

public class Blok extends Instrukcja {

    Map<Character,Zmienna> zmienne;
    Map<String, Procedura> procedury;
    List<Deklaracja> deklaracje;
    List<Instrukcja> instrukcje;
    Blok higherBlok;

    /**
     * Odczyt procedury
     * Machiato 2
     * @param id
     * @return
     */
    public Procedura FindProcedura(String id){
        if(this.procedury.containsKey(id)){
            return this.procedury.get(id);
        }
        if(this.higherBlok == null){
            return null;
        }
        return this.higherBlok.FindProcedura(id);
    }

    @Override
    public Instrukcja copy(){
        List<Deklaracja> deklaracjeRep = new LinkedList<>();
        for(Deklaracja d: this.deklaracje) deklaracjeRep.add(d.copy());
        List<Instrukcja> instrukcjeRep = new LinkedList<Instrukcja>();
        for(Instrukcja i: this.instrukcje) instrukcjeRep.add(i.copy());
        Blok bRep = new Blok(deklaracjeRep,instrukcjeRep);
        return bRep;
    }
    public void dodajInstrukcje(Instrukcja i){
        this.instrukcje.add(i);
    }




    @Override
    public void wypiszZmienne(int n){
        wypiszZmienne(n,n);
    }
    public void wypiszZmienne(int n, int originalN){
        if(n == -1)return;
        System.out.print("poziom ");
        System.out.println(originalN-n);
        for(int i = (int)('a'); i <= (int)('z'); i++){
            Zmienna z = null;
            try{
                z = this.getZmienna((char) i);
            }
            catch (IllegalArgumentException e){
                continue;
            }
            if (z != null){
                System.out.print((char) i);
                System.out.print(':' );
                System.out.println(z.wartosc());
            }

        }
        if(this.higherBlok != null){
            this.higherBlok.wypiszZmienne(n-1, originalN);
        }
        else if(n > 0){
            throw new IllegalArgumentException("wyzej juz nie ma poziomow");
        }

    }

    public int podajPoziom(){
        if(higherBlok == null)
            return 0;
        return 1 + this.higherBlok.podajPoziom();
    }
    public Zmienna getZmienna(Character a){
        // zlap char poza przedzialem
        if(zmienne.containsKey(a) && (zmienne.get(a) != null)){
            return zmienne.get(a);
        }
        else{
           if(this.higherBlok != null) {
               return this.higherBlok.getZmienna(a);
           }
           else{
               throw new IllegalArgumentException("nie ma zadeklarowanej zmiennej " + a + "\n");
               //throw exception
           }
        }
    }
    public Zmienna getZmienna_x_poziom(Character a, int x){
        if(x == 0){
            return null;
        }
        if(zmienne.containsKey(a)){
            return zmienne.get(a);
        }
        else{
            if(higherBlok != null) {
                return higherBlok.getZmienna_x_poziom(a, x-1);
            }
            return null;
        }
    }
    @Override
    public void wykonaj(Blok higherBlok) throws ExceptionInstrukcji {
        // DIFF1 wchodzimy do bloku, wiec trzeba
        if(Instrukcja.dbg.Flag != Debugv2.DebuggingFlag.noDebug) Instrukcja.dbg.updateBlok(this);
        super.wykonajDebug(this);
        if(Instrukcja.dbg.Flag == Debugv2.DebuggingFlag.exit) return;
        this.higherBlok = higherBlok;
        //for(int i = (int) 'a'; i <= int('z'); i++){}  // po co?
        for(Deklaracja d: this.deklaracje){
            try {
                d.deklaruj(this);
            }
            catch(Exception e){
                continue;
            }
        }
        for(Instrukcja I: this.instrukcje){
            try {
                I.wykonaj(this);
            }
            catch(Exception e){
                throw new ExceptionInstrukcji(this);
            }
        }

        // DIFF1 konczymy wykonanie tego bloku, wiec akt blok to bedzie blok wyzszy
        if(Instrukcja.dbg.Flag != Debugv2.DebuggingFlag.noDebug) Instrukcja.dbg.updateBlok(higherBlok);
    }
    Blok(List<Deklaracja> deklaracje0, List<Instrukcja> instrukcje0){
        this.higherBlok = null;
        this.deklaracje = deklaracje0;
        this.instrukcje = instrukcje0;
        this.zmienne = new CharMap();
        this.procedury = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Blok{" +
                "deklaracje=" + deklaracje +
                '}';
    }
}
