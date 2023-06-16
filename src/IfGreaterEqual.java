import java.util.LinkedList;

public class IfGreaterEqual extends InstrukcjaWarunkowa{

    @Override
    public String toString() {
        return "{if " +
                "w1=" + w1 +
                "=> w2=" + w2 +
                '}';
    }

    public IfGreaterEqual(Wyrazenie w1, Wyrazenie w2, LinkedList<Instrukcja> bTrue, LinkedList<Instrukcja> bFalse) {
        super(w1, w2, bTrue, bFalse);
    }

    @Override
    boolean Warunek(Blok higherBlok){
        int i1 = this.w1.wartosc(higherBlok);
        int i2 = this.w2.wartosc(higherBlok);
        return i1 >= i2;

    }
}
