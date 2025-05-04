import javax.swing.plaf.nimbus.State;

interface Test {
    void get();

    int returnsomthing();
}

interface Test2 {
    void get();
}

class CLTest implements Test {

    @Override
    public void get() {
        System.out.println("hege");
    }

    @Override
    public int returnsomthing() {
        return 0;
    }

    public CLTest() {

    }
}

class CLTest2 implements Test2 {
    @Override
    public void get() {

    }

    public CLTest2() {
    }
}


public class Main {
    public static void main(String[] args) {

        Thread runa = new Thread();


        String name = runa.getName();
        int priority = runa.getPriority();

        Thread.State state = (runa.getState());

        System.out.println(name);
        System.out.println(priority);
        System.out.println(state);
    }
}