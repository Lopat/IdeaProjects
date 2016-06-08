package testpackage;

public class Note extends Comp {

    public void charge(){
        System.out.println("charge");
    }

    @Override
    public void doAction() {
        super.doAction();
        this.charge();
    }
}
