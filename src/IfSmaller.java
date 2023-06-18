import java.util.LinkedList;

public class IfSmaller extends InstrukcjaWarunkowa{
    public static IfSmaller of(Wyrazenie w1, Wyrazenie w2, LinkedList<Instrukcja> listT,LinkedList<Instrukcja> listF){
        return (new IfSmaller(w1,w2, listT, listF));
    }
    @Override
    public String toString() {
        return "{if" +
                "w1=" + w1 +
                "< w2=" + w2 +
                '}';
    }

    public IfSmaller(Wyrazenie w1, Wyrazenie w2, LinkedList<Instrukcja> bTrue, LinkedList<Instrukcja> bFalse) {
        super(w1, w2, bTrue, bFalse);
    }

    @Override
    boolean Warunek(Blok higherBlok){
        return this.w1.wartosc(higherBlok) < this.w2.wartosc(higherBlok);
    }
}
