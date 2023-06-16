import java.util.LinkedList;
import java.util.List;

abstract class InstrukcjaWarunkowa extends Instrukcja{

    protected Wyrazenie w1;
    protected Wyrazenie w2;
    protected LinkedList<Instrukcja> bTrue;
    protected LinkedList<Instrukcja> bFalse;
    boolean Warunek(Blok blok){
        return true;
    }

    public InstrukcjaWarunkowa(Wyrazenie w1, Wyrazenie w2, LinkedList<Instrukcja> bTrue, LinkedList<Instrukcja> bFalse) {
        this.bFalse = bFalse;
        this.bTrue = bTrue;
        this.w1 = w1;
        this.w2 = w2;
    }
    @Override
    public void wykonaj(Blok higherBlok) throws ExceptionInstrukcji {
        super.wykonajDebug(this);
        if(Instrukcja.dbg.Flag == Debugv2.DebuggingFlag.exit) return;
        boolean ifTrue = true;
        try{
            ifTrue = this.Warunek(higherBlok);
        }
        catch(Exception e){
            if(Instrukcja.dbg.Flag == Debugv2.DebuggingFlag.noDebug)
                throw new IllegalArgumentException("blad wyliczania Warunku");

            else {
                System.out.println("blad wyliczania Warunku");
            }
        }
        if (ifTrue){
            for(Instrukcja i: this.bTrue) {
                try {
                    i.wykonaj(higherBlok);
                }
                catch(Exception e){
                    throw new ExceptionInstrukcji(this);
                }
            }
        }
        else if(this.bFalse != null){
            for(Instrukcja i: this.bFalse) {
                try {
                    i.wykonaj(higherBlok);
                }
                catch(Exception e){
                    throw new ExceptionInstrukcji(this);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "InstrukcjaWarunkowa{" +
                "w1=" + w1 +
                ", w2=" + w2 +
                '}';
    }
}
