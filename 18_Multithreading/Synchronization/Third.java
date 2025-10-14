public class Third extends Thread{
    Table t;
    Third(Table t){
        this.t = t;
    }
    public void run(){
        t.printTable(18);
    }
}