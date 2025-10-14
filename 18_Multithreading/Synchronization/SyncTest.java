public class SyncTest {
    public static void main(String[] args) {
        Table t = new Table();
        First f = new First(t);
        Second s = new Second(t);
        Third th = new Third(t);

        f.start();
        s.start();
        th.start();
    }
}