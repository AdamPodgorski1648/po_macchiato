import java.util.LinkedList;

public class Lista {
    /**
     * klasa do tworzenia LinkedList (Instrukcje, Wyrazenia, Charactery)
     */
    public static LinkedList<Instrukcja> of(Instrukcja i){
        LinkedList<Instrukcja> list = new LinkedList<Instrukcja>();
        list.add(i);
        return list;
    }
    public static LinkedList<Instrukcja> of(LinkedList<Instrukcja> list,Instrukcja i){
        list.add(i);
        return list;
    }
    public static LinkedList<Wyrazenie> of(Wyrazenie w){
        LinkedList<Wyrazenie> list = new LinkedList<Wyrazenie>();
        list.add(w);
        return list;
    }

    public static LinkedList<Wyrazenie> of(LinkedList<Wyrazenie> list,Wyrazenie w){
        list.add(w);
        return list;
    }
    public static LinkedList<Character> of(char c){
        LinkedList<Character> list = new LinkedList<Character>();
        list.add(new Character(c));
        return list;
    }

    public static LinkedList<Character> of(LinkedList<Character> list,char c){
        list.add(new Character(c));
        return list;
    }
}