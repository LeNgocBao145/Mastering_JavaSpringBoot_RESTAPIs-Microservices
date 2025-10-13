// This method overcomes the drawbacks of extending Thread class
// 1. We can implement multiple interfaces
// 2. We can share the same code between multiple threads
// as all threads will share the same copy of run() method


class RunnableDemo implements Runnable{
    public void run(){
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Runnable r1 = new RunnableDemo();
        Thread t1 = new Thread(r1);
        t1.start();
        Runnable r2 = new RunnableDemo();
        Thread t2 = new Thread(r2);
        t2.start();

        // Normal method
        // This will not use multithreading
        // It will execute the run() method sequentially

        // t1.run();
        // t2.run();
    }
}