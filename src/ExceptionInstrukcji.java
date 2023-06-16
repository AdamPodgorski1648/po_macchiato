public class ExceptionInstrukcji extends Exception{
    private Instrukcja i;
    public Instrukcja getInst(){
        return this.i;
    }
    public ExceptionInstrukcji(Instrukcja i) {
        super();
        this.i = i;

    }
}
