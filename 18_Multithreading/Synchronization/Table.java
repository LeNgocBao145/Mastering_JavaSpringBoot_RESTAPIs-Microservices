public class Table{
    // synchronized keyword is used to lock the 
    // method for a particular thread
    // so that other threads have to wait until 
    // the thread completes its execution
    public synchronized void printTable(int n){ 
        for(int i = 1; i <= 5; i++){
            System.out.println(n + " * " + i + " = " + (n*i));
            try{
                Thread.sleep(400);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

