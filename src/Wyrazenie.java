abstract class Wyrazenie {
    protected Blok higherBlok;
    protected int wartosc;


    public int getWartosc() {
        return wartosc;
    }

    public int wartosc(Blok higherBlok) {
        this.wylicz(higherBlok);
        return this.wartosc;
    }
    abstract public void wylicz(Blok higherBlok);

    /**
     * wzorzec budowniczy:
     *      -> ProgramBuilder   // wewn obiekt bud blok(program)
     *      -> dla kazdej instrukcji ProgramBuilder ma .instrukcja(arg)
     *      -> dla kazdego wyrazenia ??? mamy builder ktory zwraca nowy program wedlug specyfikacji
     *      -> dla kazdego Wyrazenia, Obiekt.as( //args// ) buduje nowy obiekt i go powraca
     *
     * program = new ProgramBuilder()
     *      .declareVariable('x', ...
     *      .declareProcedure('out', List.of('a'), new BlockBuilder(). ...
     *      .przypisz
     *      .wywolaj
     *      .itp(dla kazdej)
     *      .build()
     */
}
