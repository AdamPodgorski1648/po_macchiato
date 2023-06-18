import java.util.LinkedList;

public class WywolajProcedure extends Instrukcja{

    private String id;
    private LinkedList<Wyrazenie> argumenty;

    public static WywolajProcedure of(String id, LinkedList<Wyrazenie> list ){
        return new WywolajProcedure(id,list);
    }
    public WywolajProcedure(String id, LinkedList<Wyrazenie> argumenty) {
        this.id = id;
        this.argumenty = argumenty;
    }

    @Override
    public String toString() {
        return "WywolajProcedure{" +
                "id='" + id + '\'' +
                ", argumenty=" + argumenty +
                '}';
    }

    @Override
    public void wykonaj(Blok higherBlok) throws Exception {
        this.higherBlok = higherBlok;
        super.wykonaj(this.higherBlok); // tutaj trzeba znowu zmienic zpowrotem na deklaracje  z nazwa
        // wez procedure z higherBloku
        Procedura p = higherBlok.FindProcedura(this.id);    // implement procedura
        p.wywolaj(this.argumenty);
        p.wykonaj(this.higherBlok);
    }
}
