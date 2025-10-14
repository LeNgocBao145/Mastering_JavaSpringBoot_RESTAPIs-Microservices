public class SynchDisplayDemo{
    public static void main(String[] args) {
        Display d = new Display();
        Thread t1 = new Thread(() -> d.printCapitals());
        Thread t2 = new Thread(() -> d.printSmaller());
        t1.start();
        t2.start();

        // new Thread(() -> d.printCapitals()).start();
        // new Thread(() -> d.printSmaller()).start();
        
    }
}