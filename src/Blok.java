import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// na razie git

public class Blok extends Instrukcja {

    Map<Character,Zmienna> zmienne;
    Map<String, Procedura> procedury;
    LinkedList<Deklaracja> deklaracje;
    LinkedList<Instrukcja> instrukcje;
    Blok higherBlok;

    public void runDebug(){
        Instrukcja.debugStart(this);
    }
    public void runExecute(){
        Instrukcja.executeStart(this);
    }
    /**
     * Blok builder
     */
    public static class BlokBuilder{
        public BlokBuilder() {
            this.dekl = new LinkedList<>();
            this.instr = new LinkedList<>();
        }
        // podstawowa konstrukcja buildera
        public BlokBuilder addInstrukcja(Instrukcja i){
            this.instr.add(i);
            return this;
        }
        public BlokBuilder print(Wyrazenie w){
            return this.addInstrukcja(new Print(w));
        }
        public BlokBuilder assign(char c, Wyrazenie w){
            return this.addInstrukcja(new PrzypisanieWartosci(new Character(c),w));
        }
        public BlokBuilder loop(char c, Wyrazenie w, LinkedList<Instrukcja> list){
            return this.addInstrukcja(new Petla(new Character(c),w,list));
        }
        public BlokBuilder invoke(String id, LinkedList<Wyrazenie> list ){
            return this.addInstrukcja(new WywolajProcedure(id,list));
        }
        public BlokBuilder block(Blok b){
            return this.addInstrukcja(b);
        }

        public BlokBuilder ifEqual(Wyrazenie w1, Wyrazenie w2,LinkedList<Instrukcja> listT,LinkedList<Instrukcja> listF){
            return this.addInstrukcja(new IfEqual(w1,w2, listT, listF));
        }
        public BlokBuilder ifDiff(Wyrazenie w1, Wyrazenie w2, LinkedList<Instrukcja> listT,LinkedList<Instrukcja> listF){
            return this.addInstrukcja(new IfDiff(w1,w2, listT, listF));
        }
        public BlokBuilder ifGreater(Wyrazenie w1, Wyrazenie w2, LinkedList<Instrukcja> listT,LinkedList<Instrukcja> listF){
            return this.addInstrukcja(new IfGreater(w1,w2, listT, listF));
        }
        public BlokBuilder ifGreaterEqual(Wyrazenie w1, Wyrazenie w2, LinkedList<Instrukcja> listT,LinkedList<Instrukcja> listF){
            return this.addInstrukcja(new IfGreaterEqual(w1,w2, listT, listF));
        }
        public BlokBuilder ifSmallerEqual(Wyrazenie w1, Wyrazenie w2, LinkedList<Instrukcja> listT,LinkedList<Instrukcja> listF){
            return this.addInstrukcja(new IfSmallerEqual(w1,w2, listT, listF));
        }
        public BlokBuilder ifSmaller(Wyrazenie w1, Wyrazenie w2, LinkedList<Instrukcja> listT,LinkedList<Instrukcja> listF){
            return this.addInstrukcja(new IfSmaller(w1,w2, listT, listF));
        }
        /*
        public static BlokBuilder recurence(){

        }
        */

        public BlokBuilder addDeklaracja(Deklaracja d){
            this.dekl.add(d);
            return this;
        }
        public BlokBuilder declareVariable(char c, Wyrazenie w){
            return this.addDeklaracja(new Deklaracja(new Character(c), w));
        }
        public BlokBuilder declareProcedure(String s,LinkedList<Character> nazwy, Blok b){
            LinkedList<Instrukcja> listI = b.instrukcje;
            DeklarujProcedure d = new DeklarujProcedure(null,null);
            d.dodeklaruj(s, listI, nazwy);
            return this.addDeklaracja(d);
        }

        public Blok build(){
            return new Blok(this.dekl, this.instr);
        }

        LinkedList<Deklaracja> dekl;
        LinkedList<Instrukcja> instr;


    }

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
        LinkedList<Deklaracja> deklaracjeRep = new LinkedList<>();
        for(Deklaracja d: this.deklaracje) deklaracjeRep.add(d.copy());
        LinkedList<Instrukcja> instrukcjeRep = new LinkedList<Instrukcja>();
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
    Blok(LinkedList<Deklaracja> deklaracje0, LinkedList<Instrukcja> instrukcje0){
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
