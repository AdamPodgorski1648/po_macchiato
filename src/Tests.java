import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;


public class Tests {

    @Test
    public void testProcedura(){

    }
    @Test
    public void testBuilderFib(){

    }
    @Test
    public void testArytmetyka(){

    }
    public void test
    @Test
    public void testMain(){ // super dziala, teraz wyjatki

        Blok b1,b2;

        Petla f1, f2;
        InstrukcjaWarunkowa e1, e2;
        Instrukcja pr1, pr2, pr3;

        //wypisanie koncowe
        LinkedList<Instrukcja> listp1 = new LinkedList<Instrukcja>();
        listp1.add(new Print(new ZmiennaWyr('k')));
        e1 = new IfEqual(new ZmiennaWyr('p'), new Literal(1),listp1,null);

        // druga petla for
        LinkedList<Instrukcja> listp2 = new LinkedList<Instrukcja>();
        listp2.add(new PrzypisanieWartosci(new Character('p'), new Literal(0)));
        e2 = new IfEqual(new Modulo(new ZmiennaWyr('k'), new ZmiennaWyr('i')),new Literal(0),listp2,null);


        LinkedList<Instrukcja> listI2 = new LinkedList<Instrukcja>();
        pr2 = new PrzypisanieWartosci(new Character('i'),new Dodawanie(new ZmiennaWyr('i'), new Literal(2)));
        listI2.add(pr2);
        listI2.add(e2);
        f2 = new Petla(new Character('i'), new Odejmowanie(new ZmiennaWyr('k'), new Literal(2)),listI2);

        //pierwsza petla for
        pr3 = new PrzypisanieWartosci(new Character('p'), new Literal(0));

        LinkedList<Deklaracja> listD2 = new LinkedList<>();
        listD2.add(new Deklaracja(new Character('p'), new Literal(1)));
        LinkedList<Instrukcja> listI3 = new LinkedList<Instrukcja>();
        pr1 = new PrzypisanieWartosci(new Character('k'),new Dodawanie(new ZmiennaWyr('k'), new Literal(2)));
        listI3.add(pr1);
        listI3.add(f2);
        listI3.add(e1);

        b2 = new Blok(listD2, listI3);
        LinkedList<Instrukcja> listF1 = new LinkedList<Instrukcja>();
        listF1.add(b2);
        f1 = new Petla(new Character('k'), new Odejmowanie(new ZmiennaWyr('n'), new Literal(1)),listF1);

        // blok 1
        LinkedList<Deklaracja> listD1 = new LinkedList<Deklaracja>();
        listD1.add(new Deklaracja('n', new Literal(30)));
        LinkedList<Instrukcja> listI1 = new LinkedList<>();
        listI1.add(f1);
        b1 = new Blok(listD1, listI1);
        Instrukcja.executeModeOn();
        //Instrukcja.debugModeOn();
        Instrukcja.debugStart(b1);
        // wlaczamy obie wersje za pomoca debugStart ( tryb dzialania robimy za pomoca execute mode on i debug mode on)
    }
    @Test
    public void testBlok(){     // dziala
        LinkedList<Deklaracja> listD = new LinkedList<Deklaracja>();
        LinkedList<Instrukcja> listI = new LinkedList<Instrukcja>();
        Print p = new Print(new ZmiennaWyr('a'));
        Deklaracja D = new Deklaracja(new Character('a'), new Literal(1));
        listD.add(D);
        listI.add(p);
        Blok b = new Blok(listD, listI);// dodaj cos
        Instrukcja.executeModeOn();
        Instrukcja.debugStart(b);



    }
    @Test
    public void testMnozenie(){     // dziala
        LinkedList<Deklaracja> listD = new LinkedList<Deklaracja>();
        LinkedList<Instrukcja> listI = new LinkedList<Instrukcja>();
        Print p = new Print(new Mnozenie(new ZmiennaWyr('a'), new Literal(7)));
        Deklaracja D = new Deklaracja(new Character('a'), new Literal(1));
        listD.add(D);
        listI.add(p);
        Blok b = new Blok(listD, listI);// dodaj cos
        Instrukcja.executeModeOn();
        Instrukcja.debugStart(b);

    }
    @Test
    public void TestIf() {
        Instrukcja print = new Print(new ZmiennaWyr('k'));
        LinkedList<Instrukcja> listif2 = new LinkedList<Instrukcja>(); listif2.add(print);
        InstrukcjaWarunkowa if2 = new IfEqual(new ZmiennaWyr('k'),new Literal(1),listif2,null);
        LinkedList<Instrukcja> listI = new LinkedList<Instrukcja>();
        LinkedList<Deklaracja> listD = new LinkedList<Deklaracja>();
        listI.add(if2);
        Deklaracja d1 = new Deklaracja(new Character('n'), new Literal(30));
        Deklaracja dk = new Deklaracja(new Character('k'), new Literal( 1));
        listD.add(d1);
        listD.add(dk);
        Blok b1 = new Blok(listD, listI);
        Instrukcja.executeModeOn();
        Instrukcja.debugStart(b1);

    }
    @Test
    public void TestFib_div7() { // klasyczny fibonacci (n = 30 wartosci)
        // n = 30
        // i = 1
        // j = 1
        // for k , n-1
        //      l = i + j
        //      i = j
        //      j = l
        //      print l

        Deklaracja dn, di, dj;
        dn = new Deklaracja(new Character('n'), new Literal(30));
        di = new Deklaracja(new Character('i'), new Literal(1));
        dj = new Deklaracja(new Character('j'), new Literal(1));
        Deklaracja dl = new Deklaracja(new Character('l'), new Literal(2));
        Print p = new Print(new Dzielenie(new ZmiennaWyr('l'), new Literal(7)));
        PrzypisanieWartosci pr1, pr2, pr3;
        pr1 = new PrzypisanieWartosci('l', new Dodawanie(new ZmiennaWyr('i'), new ZmiennaWyr('j')));
        pr2 = new PrzypisanieWartosci('i', new ZmiennaWyr('j'));
        pr3 = new PrzypisanieWartosci('j', new ZmiennaWyr('l'));
        LinkedList<Instrukcja> listfor = new LinkedList<Instrukcja>();
        listfor.add(pr1); listfor.add(pr2); listfor.add(pr3); listfor.add(p);
        Petla f = new Petla('k',new ZmiennaWyr('n'), listfor);
        LinkedList<Instrukcja> listMain = new LinkedList<>();
        listMain.add(f);
        LinkedList<Deklaracja> listDek = new LinkedList<>();
        listDek.add(dn); listDek.add(di); listDek.add(dj); listDek.add(dl);
        Blok b1 = new Blok(listDek, listMain);
        Instrukcja.executeModeOn();
        Instrukcja.debugStart(b1);
    }

    @Test
    public void TestFib() { // klasyczny fibonacci (n = 30 wartosci)
        // n = 30
        // i = 1
        // j = 1
        // for k , n-1
        //      l = i + j
        //      i = j
        //      j = l
        //      print l

        Deklaracja dn, di, dj;
        dn = new Deklaracja(new Character('n'), new Literal(30));
        di = new Deklaracja(new Character('i'), new Literal(1));
        dj = new Deklaracja(new Character('j'), new Literal(1));
        Deklaracja dl = new Deklaracja(new Character('l'), new Literal(2));
        Print p = new Print(new ZmiennaWyr('l'));
        PrzypisanieWartosci pr1, pr2, pr3;
        pr1 = new PrzypisanieWartosci('l', new Dodawanie(new ZmiennaWyr('i'), new ZmiennaWyr('j')));
        pr2 = new PrzypisanieWartosci('i', new ZmiennaWyr('j'));
        pr3 = new PrzypisanieWartosci('j', new ZmiennaWyr('l'));
        LinkedList<Instrukcja> listfor = new LinkedList<Instrukcja>();
        listfor.add(pr1); listfor.add(pr2); listfor.add(pr3); listfor.add(p);
        Petla f = new Petla('k',new ZmiennaWyr('n'), listfor);
        LinkedList<Instrukcja> listMain = new LinkedList<>();
        listMain.add(f);
        LinkedList<Deklaracja> listDek = new LinkedList<>();
        listDek.add(dn); listDek.add(di); listDek.add(dj); listDek.add(dl);
        Blok b1 = new Blok(listDek, listMain);
        Instrukcja.executeModeOn();
        Instrukcja.debugStart(b1);

    }


    @Test
    public void TestModulo() {

        Print p = new Print(new ZmiennaWyr('l'));
        LinkedList<Instrukcja> listif2 = new LinkedList<Instrukcja>();
        listif2.add(p);
        /*dzialajace modulo*/
        InstrukcjaWarunkowa if2 = new IfEqual(new Literal(0),new Modulo(new ZmiennaWyr('l'), new Literal(7)),listif2,null);
        /* nie dzialajace modulo*/
        //InstrukcjaWarunkowa if2 = new IfEqual(new Literal(3), new Modulo(new ZmiennaWyr('l'), new Literal(0)), listif2, null);

        // reszty z dzielenia przez 7 dla fibonaciego = 0
        Deklaracja dn, di, dj;
        dn = new Deklaracja(new Character('n'), new Literal(30));
        di = new Deklaracja(new Character('i'), new Literal(1));
        dj = new Deklaracja(new Character('j'), new Literal(1));
        Deklaracja dl = new Deklaracja(new Character('l'), new Literal(2));
        PrzypisanieWartosci pr1, pr2, pr3;
        pr1 = new PrzypisanieWartosci('l', new Dodawanie(new ZmiennaWyr('i'), new ZmiennaWyr('j')));
        pr2 = new PrzypisanieWartosci('i', new ZmiennaWyr('j'));
        pr3 = new PrzypisanieWartosci('j', new ZmiennaWyr('l'));
        LinkedList<Instrukcja> listfor = new LinkedList<Instrukcja>();
        listfor.add(pr1);
        listfor.add(pr2);
        listfor.add(pr3);
        listfor.add(if2);
        Petla f = new Petla('k', new ZmiennaWyr('n'), listfor);
        LinkedList<Instrukcja> listMain = new LinkedList<>();
        listMain.add(f);
        LinkedList<Deklaracja> listDek = new LinkedList<>();
        listDek.add(dn);
        listDek.add(di);
        listDek.add(dj);
        listDek.add(dl);
        Blok b1 = new Blok(listDek, listMain);
        Instrukcja.executeModeOn();
        Instrukcja.debugStart(b1);

    }
    @Test
    public void TestConditionals() {

        // zawsze wypisze 3 warunki, dla = -> eq, seq, geq
        //                          dla > g, geq, diff
        //                          dla < s, seq, diff


        Print p1 = new Print(new Literal(1));
        Print p2 = new Print(new Literal(2));
        Print p3 = new Print(new Literal(3));
        Print p4 = new Print(new Literal(4));
        Print p5 = new Print(new Literal(5));
        Print p6 = new Print(new Literal(6));
        LinkedList<Instrukcja> listif1 = new LinkedList<Instrukcja>();
        LinkedList<Instrukcja> listif2 = new LinkedList<Instrukcja>();
        LinkedList<Instrukcja> listif3 = new LinkedList<Instrukcja>();
        LinkedList<Instrukcja> listif4 = new LinkedList<Instrukcja>();
        LinkedList<Instrukcja> listif5 = new LinkedList<Instrukcja>();
        LinkedList<Instrukcja> listif6 = new LinkedList<Instrukcja>();
        listif1.add(p1);
        listif2.add(p2);
        listif3.add(p3);
        listif4.add(p4);
        listif5.add(p5);
        listif6.add(p6);
        InstrukcjaWarunkowa if1 = new IfEqual(new Literal(3),new Modulo(new ZmiennaWyr('l'), new Literal(7)),listif1,null);
        InstrukcjaWarunkowa if2 = new IfDiff(new Literal(3),new Modulo(new ZmiennaWyr('l'), new Literal(7)),listif2,null);
        InstrukcjaWarunkowa if3 = new IfGreaterEqual(new Literal(3),new Modulo(new ZmiennaWyr('l'), new Literal(7)),listif3,null);
        InstrukcjaWarunkowa if4 = new IfGreater(new Literal(3),new Modulo(new ZmiennaWyr('l'), new Literal(7)),listif4,null);
        InstrukcjaWarunkowa if5 = new IfSmaller(new Literal(3),new Modulo(new ZmiennaWyr('l'), new Literal(7)),listif5,null);
        InstrukcjaWarunkowa if6 = new IfSmallerEqual(new Literal(3),new Modulo(new ZmiennaWyr('l'), new Literal(7)),listif6,null);

        // reszty z dzielenia przez 7 dla fibonaciego = 3 i inne rozne
        Deklaracja dn, di, dj;
        dn = new Deklaracja(new Character('n'), new Literal(30));
        di = new Deklaracja(new Character('i'), new Literal(1));
        dj = new Deklaracja(new Character('j'), new Literal(1));
        Deklaracja dl = new Deklaracja(new Character('l'), new Literal(2));
        PrzypisanieWartosci pr1, pr2, pr3;
        pr1 = new PrzypisanieWartosci('l', new Dodawanie(new ZmiennaWyr('i'), new ZmiennaWyr('j')));
        pr2 = new PrzypisanieWartosci('i', new ZmiennaWyr('j'));
        pr3 = new PrzypisanieWartosci('j', new ZmiennaWyr('l'));
        LinkedList<Instrukcja> listfor = new LinkedList<Instrukcja>();
        listfor.add(pr1);
        listfor.add(pr2);
        listfor.add(pr3);
        Print p = new Print(new ZmiennaWyr('l'));
        listfor.add(p); // wypisanie zmiennej, potem czy jest podzielna i przez co
        listfor.add(if1);listfor.add(if2);listfor.add(if3);listfor.add(if4);listfor.add(if5);listfor.add(if6);
        Petla f = new Petla('k', new ZmiennaWyr('n'), listfor);
        LinkedList<Instrukcja> listMain = new LinkedList<>();
        listMain.add(f);
        LinkedList<Deklaracja> listDek = new LinkedList<>();
        listDek.add(dn);
        listDek.add(di);
        listDek.add(dj);
        listDek.add(dl);
        Blok b1 = new Blok(listDek, listMain);
        Instrukcja.executeModeOn();
        Instrukcja.debugStart(b1);

    }
    @Test
    public void CzyMoznaRekurencje(){
        Print p = new Print(new ZmiennaWyr('a'));
        Deklaracja D = new Deklaracja(new Character('a'), new Literal(100));
        PrzypisanieWartosci pr1 = new PrzypisanieWartosci('a', new Odejmowanie(new ZmiennaWyr('a'),new Literal(1)));
        Blok b1, b2;
        LinkedList<Deklaracja> listD = new LinkedList<Deklaracja>();
        LinkedList<Instrukcja> listI = new LinkedList<Instrukcja>();
        LinkedList<Instrukcja> listif2 = new LinkedList<Instrukcja>();
        b1 = new Blok(listD, listI);// dodaj cos
        listif2.add(b1);
        InstrukcjaWarunkowa if2 = new IfGreater(new ZmiennaWyr('a'),new Literal(0),listif2,null);
        listD.add(D);
        listI.add(p);listI.add(pr1);listI.add(if2);

        Instrukcja.executeModeOn();
        Instrukcja.debugStart(b1);
    }
}

