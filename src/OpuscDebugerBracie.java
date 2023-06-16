public class OpuscDebugerBracie extends Instrukcja{
    private Blok higherBlok;
    @Override
    public String toString() {
        return "OpuscDebugerBracie";
    }

    public OpuscDebugerBracie() {
        this.higherBlok = null;
    }
}
