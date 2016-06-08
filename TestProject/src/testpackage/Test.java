package testpackage;

public class Test {

    public static void main(String[] args) {
        
        Comp n = new Note();
        Comp c = new Comp();

        doSmth(n);
        doSmth(c);
    }

    private static void doSmth(Comp n) {

        n.doAction();
    }
}
