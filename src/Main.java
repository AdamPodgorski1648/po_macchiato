import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] Args) {


        /**
         * nowy program (v1.1)
         */

        Blok program = new Blok.BlokBuilder()
                .declareVariable('x', Literal.of(101))
                .declareVariable('y', Literal.of(1))
                .declareProcedure("out", Lista.of('a'), new Blok.BlokBuilder()
                        .print(Dodawanie.of(ZmiennaWyr.named('a'), ZmiennaWyr.named('x')))
                        .build()
                )
                .assign('x', Odejmowanie.of(ZmiennaWyr.named('x'), ZmiennaWyr.named('y')))
                .invoke("out", Lista.of(ZmiennaWyr.named('x')))
                .invoke("out", Lista.of(Literal.of(100)))
                .block(new Blok.BlokBuilder()
                        .declareVariable('x', Literal.of(10))
                        .invoke("out", Lista.of(Literal.of(100)))
                        .build()
                )
                .build();

        program.runDebug();    // with debug

        //program.runExecute();

        /* old program (v1)
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

        List<Deklaracja> listD2 = new LinkedList<>();
        listD2.add(new Deklaracja(new Character('p'), new Literal(1)));
        List<Instrukcja> listI3 = new LinkedList<Instrukcja>();
        pr1 = new PrzypisanieWartosci(new Character('k'),new Dodawanie(new ZmiennaWyr('k'), new Literal(2)));
        listI3.add(pr1);
        listI3.add(f2);
        listI3.add(e1);

        b2 = new Blok(listD2, listI3);
        List<Instrukcja> listF1 = new LinkedList<Instrukcja>();
        listF1.add(b2);
        f1 = new Petla(new Character('k'), new Odejmowanie(new ZmiennaWyr('n'), new Literal(1)),listF1);

        // blok 1
        LinkedList<Deklaracja> listD1 = new LinkedList<Deklaracja>();
        listD1.add(new Deklaracja('n', new Literal(30)));
        LinkedList<Instrukcja> listI1 = new LinkedList<>();
        listI1.add(f1);
        b1 = new Blok(listD1, listI1);
        //Instrukcja.executeModeOn();
        //b1.wykonaj(null);
        Instrukcja.debugModeOn();

        Instrukcja.debugStart(b1);


        // var  n = 30;         d1
        // for k n-1            p1
        //    {
        //      var p = 1;      d2
        //      k = k + 2;      pr1
        //      for i k-2       p2
        //          i = i+2;    pr2
        //          if( k%i = 0)    if1
        //          p = 0       pr3
        //      if(p == 1)      if2
        //          print k;    print
        */

    }
}
