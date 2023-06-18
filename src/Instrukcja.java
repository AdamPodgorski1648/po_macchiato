abstract class Instrukcja {

    public Blok getHigherBlok() {
        return higherBlok;
    }

    public Instrukcja copy(){
        return this;
    }
    @Override
    public String toString() {
        return "Instrukcja{" +
                '}';
    }

    protected Blok higherBlok;

    public void wypiszZmienne(int n){
        if(this.higherBlok != null) {
            this.higherBlok.wypiszZmienne(n, n);
        }
    }
    static Debugv2 dbg = new Debugv2(Debugv2.DebuggingFlag.cont); // statyczny debugging tool
    static void debugModeOn() {
        dbg = new Debugv2(Debugv2.DebuggingFlag.step);
    }
    static void executeModeOn(){
        dbg = new Debugv2(Debugv2.DebuggingFlag.noDebug);
    }
    public void wykonaj(Blok higherBlok) throws Exception {
        if(dbg.isDebug() == true) {

            int rep = debug();
            if (rep == 0) return; // exit
            else if (rep == -1 /*|| rep == 3*/) { /** CHECK */
                while (dbg.ask(this) != 0) {// ask powinien zwracac
                    ;
                }

            }
        }
    }

    public void wykonajDebug(Instrukcja ins){ // pyta dopoki nie ma kontynuowac
        if(dbg.isDebug() == true) {

            int rep = debug();
            if (rep == 0) return; // exit
            else if (rep == -1) {
                while (dbg.ask(ins) != 0) {
                    ;
                }
            }

        }
    }
    static int debug(){
        int rep = dbg.instrukcja();
        return rep;
    }

    static void executeStart(Blok blok){
        Instrukcja.executeModeOn();
        try {
            //debugModeOn();
            blok.wykonaj(null);
        }
        catch(ExceptionInstrukcji e){
            //Instrukcja.dbg.printPoziom();
            if(Instrukcja.dbg.isDebug()) {
                e.getInst().wypiszZmienne(0);
                System.out.print(e.getInst());
            }
        }
    }

    static void debugStart(Blok blok){
        Instrukcja.dbg.Flag = Debugv2.DebuggingFlag.step;

        try {
            //debugModeOn();
            blok.wykonaj(null);
        }
        catch(ExceptionInstrukcji e){
            //Instrukcja.dbg.printPoziom();
            if(Instrukcja.dbg.isDebug()) {
                e.getInst().wypiszZmienne(0);
                System.out.print(e.getInst());
            }
        }

        if(dbg.Flag != Debugv2.DebuggingFlag.noDebug){
            System.out.println("debugowanie zakonczone");
            if(dbg.steps() > 1){
                System.out.println("za duzo steps");
            }
            while(dbg.Flag != Debugv2.DebuggingFlag.exit){
                dbg.ask(new OpuscDebugerBracie());
            }
        }
    }
}
