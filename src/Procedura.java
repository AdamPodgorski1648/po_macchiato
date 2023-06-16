import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Procedura extends Blok {
    private HashMap<Character, Character> mapaZmiennych;
    private LinkedList<Character> nazwyZmiennychWewn;
    @Override
    public Zmienna getZmienna(Character a) {
        if(mapaZmiennych.containsKey(a)){
            return super.getZmienna(a);
        }
        return null;
    }

    public Procedura(List<Instrukcja> instrukcje0, LinkedList<Character> nazwyZmiennychWewn) {
        this.zmienne = null;
        this.procedury = null;
        this.instrukcje = instrukcje0;
        this.nazwyZmiennychWewn = nazwyZmiennychWewn;
    }
    public void wywolaj(LinkedList<Wyrazenie> argumenty){
        this.deklaracje = new LinkedList<>();

        // check, if arg.size = char.size
        if(argumenty.size() != this.nazwyZmiennychWewn.size()){
            // throw exception
        }
        // obliczamy wartosci od pierwszej podanej
        for(int i = 0; i < argumenty.size(); i++){
            this.deklaracje.add(new Deklaracja(nazwyZmiennychWewn.get(i), argumenty.get(i)));
        }

    }
}
