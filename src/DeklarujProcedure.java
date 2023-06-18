import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DeklarujProcedure extends Deklaracja{
    private String id;
    private LinkedList<Instrukcja> instrukcje;
    private LinkedList<Character> nazwyZmiennychWewn;
    public DeklarujProcedure(Character c, Wyrazenie w){
        super(null,null);
    }
    public void dodeklaruj(String id, LinkedList<Instrukcja> instrukcje, LinkedList<Character> nazwyZmiennychWewn) {
        this.id = id;
        this. instrukcje = instrukcje;
        this.nazwyZmiennychWewn = nazwyZmiennychWewn;
    }
    @Override
    public void deklaruj(Blok higherBlok) throws Exception {
        Map<String, Procedura> procedury = higherBlok.procedury;
        // utworz nowa Procedure i dodaj ja do mapy procedur
        Procedura p = new Procedura(null, this.instrukcje);
        p.initZmienneWewn(this.nazwyZmiennychWewn);
        procedury.put(this.id,p);
    }

    @Override
    public String toString() {
        return "Deklaruj Proc {" +
                id +
                "zmienne (" +
                nazwyZmiennychWewn +
                '}';
    }
}
