// This method overcomes the drawbacks of extending Thread class
// 1. We can implement multiple interfaces
// 2. We can share the same code between multiple threads
// as all threads will share the same copy of run() method


class RunnableDemo implements Runnable{
    public void run(){
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
            try{
                Thread.sleep(600, 500); // sleep(ms, ns) => sleep for ms (miliseconds) + ns (nanoseconds)
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new RunnableDemo();
        Thread t1 = new Thread(r1);
        t1.start();

        // Method join() is used to wait 
        // for a thread to finish its execution
        // t1.join(); // wait for t1 to finish for indefinite time

        t1.join(2000); // wait for t1 to finish just for 2 seconds

        Runnable r2 = new RunnableDemo();
        Thread t2 = new Thread(r2);
        t2.start();

        Runnable r3 = new RunnableDemo();
        Thread t3 = new Thread(r3);
        t3.start();

        // Normal method
        // This will not use multithreading
        // It will execute the run() method sequentially

        // t1.run();
        // t2.run();
    }
}