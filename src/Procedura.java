import java.util.LinkedList;

public class Procedura extends Blok {
    private LinkedList<Character> nazwyZmiennychWewn;

    public Procedura(LinkedList<Deklaracja> dekl, LinkedList<Instrukcja> instrukcje0)  {
        super(null,instrukcje0); // CHECK
    }
    public void initZmienneWewn(LinkedList<Character> nazwyZmiennychWewn) {
        this.nazwyZmiennychWewn = nazwyZmiennychWewn;
    }

    @Override
    public String toString() {
        return "Procedura{" +
                "argumenty = " + this.nazwyZmiennychWewn +
                '}';
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
