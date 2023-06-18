import java.util.LinkedList;

public class IfDiff extends InstrukcjaWarunkowa{
    public static IfDiff of(Wyrazenie w1, Wyrazenie w2, LinkedList<Instrukcja> listT,LinkedList<Instrukcja> listF){
        return (new IfDiff(w1,w2, listT, listF));
    }
    public IfDiff(Wyrazenie w1, Wyrazenie w2, LinkedList<Instrukcja> bTrue, LinkedList<Instrukcja> bFalse) {
        super(w1, w2, bTrue, bFalse);
    }
    public String toString() {
        return "{if" +
                "w1=" + w1 +
                "<> w2=" + w2 +
                '}';
    }

    @Override
    boolean Warunek(Blok higherBlok){
        return this.w1.wartosc(higherBlok) != this.w2.wartosc(higherBlok);
    }
}
