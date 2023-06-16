import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DeklarujProcedure extends Deklaracja{
    private String id;
    private LinkedList<Instrukcja> instrukcje;
    private LinkedList<Character> nazwyZmiennychWewn;
    public DeklarujProcedure(String id, LinkedList<Instrukcja> instrukcje, LinkedList<Character> nazwyZmiennychWewn) {
        // zapisz id i liste instrukcji
        this.id = id;
        this. instrukcje = instrukcje;
        this.nazwyZmiennychWewn = nazwyZmiennychWewn;
    }
    @Override
    public void deklaruj(Blok higherBlok) throws Exception {
        Map<String, Procedura> procedury = higherBlok.procedury;
        // utworz nowa Procedure i dodaj ja do mapy procedur
        Procedura p = new Procedura(this.instrukcje, this.nazwyZmiennychWewn);
        procedury.put(this.id,p);
    }
}
