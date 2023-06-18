import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Debugv2 {
    public Blok aktualnyBlok;
    public void printPoziom(){
        this.aktualnyBlok.wypiszZmienne(0);
    }
    public int poziomy() {
        return this.poziomy;
    }
    public int steps() {
        return this.steps;
    }
    public void setStep(int i){
        this.steps = i;
    }
    public void updateBlok(Blok blok){
        this.aktualnyBlok = blok;
    }
    private int getNumer(String s){
        int i = 0;
        char c = s.charAt(i);
        while(c == ' ' && i < s.length()){
            i++;
            c = s.charAt(i);
        }
        if(i == s.length())
            return -1;
        else
            return Integer.parseInt(s.substring(i));
    }

    public enum DebuggingFlag{
        cont,
        step,
        print,
        noDebug,
        exit;

    }       // steps - po zakonczeniu instrukcji if (steps 0 -> ask) else steps --
    public DebuggingFlag Flag;
    private int steps;
    private int poziomy;
    public boolean isDebug(){
        return this.Flag != DebuggingFlag.noDebug;
    }

    public int ask(Instrukcja i){
        if(this.Flag == DebuggingFlag.step)
            System.out.println(i);
        Scanner scan = new Scanner(System.in);
        /*
        char cin = (char) scan.nextByte();
         */
        String in = scan.nextLine();
        char cin = in.charAt(0);

        if(cin == 'm'){         // memory dump
            String filePath = in.substring(2);
            try {
                OutputStream stream = new FileOutputStream(filePath);
                String s = "Procedury: " + this.aktualnyBlok.printProcedury() + "\nZmienne: "
                        + this.aktualnyBlok.printZmienne() + "\n";
                // s to file
                byte[] strToBytes = s.getBytes();
                stream.write(strToBytes);
                //stream.flush(); //??????
                stream.close();


            }
            catch (Exception e) {
                return 2;
            }

            return 1;
        }
        if(cin == 'c'){         // continue
            this.Flag = DebuggingFlag.cont;
            return 0;
        }
        if(cin == 'e'){         // exit
            this.Flag = DebuggingFlag.exit;
            return 0;
        }
        if(cin == 'd'){         // print vars
            this.Flag = DebuggingFlag.print;
            //try
            try {
                if(this.aktualnyBlok != null) {

                    String num = in.substring(1);
                    this.poziomy = this.getNumer(num);
                    int poz = this.aktualnyBlok.podajPoziom();
                    if (poz < this.poziomy) {
                        System.out.println("podales za duzy poziom zagniezdzenia");
                    } else
                        this.aktualnyBlok.wypiszZmienne(this.poziomy());
                }
                return 1;
            }
            catch (Exception e){
                System.out.println("nieprawidlowa operacja");
            }
        }
        if(cin == 's'){         // step
            this.Flag = DebuggingFlag.step;
            String num = in.substring(1);
            this.steps = this.getNumer(num);
            if(this.steps == -1){
                // exception
            }
            if(this.steps == 0) {
                return 1;
            }
            else if(this.steps > 0){
                return 0;
            }
        }
        else{
            //exception
            throw new InputMismatchException("blad inputu");
        }
        // wejscie z systemu
        // zmiana na opcje
        return -1;
    }
    public int instrukcja(){
        if(this.Flag == DebuggingFlag.cont){
            return 2;
        }
        if(this.Flag == DebuggingFlag.step){

            steps --;
            if(steps > 0){
                return 1;
            }
            return -1;
        }
        return 0;
    }

    public void step(int i){
        this.steps = i;
        this.Flag = DebuggingFlag.step;
    }
    public void cont(){
        this.Flag = DebuggingFlag.cont;
    }
    public void exit(){
        this.Flag = DebuggingFlag.exit;
    }
    public void print(){
        this.Flag = DebuggingFlag.print;
    }
    public Debugv2(DebuggingFlag startingflag){
        this.Flag = startingflag;
        this.steps = 0;
    }
}
