import java.util.List;
import java.util.Map;

// na razie git
public class Deklaracja {


    public Deklaracja copy(){
        return new Deklaracja(this.character, this.w);
    }
    @Override
    public String toString() {
        return "Deklaracja{" +
                "character=" + character +
                " = " + w +
                '}';
    }

    Character character;

    Wyrazenie w;
    Deklaracja(Character c, Wyrazenie w){
        this.character = c;
        this.w = w;
    }
    public void deklaruj(Map<Character,Zmienna> zmienne, Blok higherBlok) throws Exception {
        int wartosc = 0;
        try{
            wartosc = w.wartosc(higherBlok);
        }
        catch(Exception e){
            if(Instrukcja.dbg.Flag == Debugv2.DebuggingFlag.noDebug)
                throw new Exception("blad wyliczania wyrazenia");
            else {
                System.out.println("blad wyliczania wyrazenia");
                return;
            }
        }
        Zmienna z = zmienne.putIfAbsent(this.character, new Zmienna(wartosc));
        if (z != null){
            throw new IllegalArgumentException("podwojna deklaracja");
        }
        // if z == null return cos zlego
    }

}
