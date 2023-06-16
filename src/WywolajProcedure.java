import java.util.LinkedList;

public class WywolajProcedure extends Instrukcja{

    private String id;
    private LinkedList<Wyrazenie> argumenty;

    public WywolajProcedure(String id, LinkedList<Wyrazenie> argumenty) {
        this.id = id;
        this.argumenty = argumenty;
    }

    @Override
    public void wykonaj(Blok higherBlok) throws Exception {
        super.wykonaj(higherBlok);
        // wez procedure z higherBloku
        Procedura p = higherBlok.FindProcedura(this.id);    // implement procedura
        p.wywolaj(this.argumenty);
        p.wykonaj(this.higherBlok);
    }
}
