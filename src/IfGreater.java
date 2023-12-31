import java.util.LinkedList;

public class IfGreater extends InstrukcjaWarunkowa{
    public static IfGreater of(Wyrazenie w1, Wyrazenie w2, LinkedList<Instrukcja> listT,LinkedList<Instrukcja> listF){
        return (new IfGreater(w1,w2, listT, listF));
    }
    public IfGreater(Wyrazenie w1, Wyrazenie w2, LinkedList<Instrukcja> bTrue, LinkedList<Instrukcja> bFalse) {
        super(w1, w2, bTrue, bFalse);
    }
    public String toString() {
        return "{if" +
                "w1=" + w1 +
                "< w2=" + w2 +
                '}';
    }

    @Override
    boolean Warunek(Blok higherBlok) {
        return this.w1.wartosc(higherBlok) > this.w2.wartosc(higherBlok);
    }
}
