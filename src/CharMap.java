import java.util.HashMap;
import java.util.Map;

public class CharMap extends HashMap {
    public Zmienna put(Character key, Zmienna value) {

        int i = (int) key.charValue();
        if(i <= (int) 'z' && i >= (int) 'a'){
            return (Zmienna)super.put(key, value);
        }
        return null;
        //exception
    }
    CharMap(){
        // hints????
        super(new HashMap<Character,Zmienna>());
        for(int i = (int) 'a';i <= (int) 'z'; i++){
            this.put(new Character((char) i), null);
        }
    }

    // czy to wszystko???
    // nie bronimy sie przed zlymi obiektami !!!
}
