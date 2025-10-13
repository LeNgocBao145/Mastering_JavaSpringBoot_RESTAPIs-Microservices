// This method has some drawbacks
// 1. We cannot extend any other class as Java does not 
// support multiple inheritance
// 2. We cannot share the same code between multiple threads
// as each thread will have its own copy of run() method


class Multi extends Thread{
    // Thread Scheduler
    public void run(){ // CS - Critical Section
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Multi t1 = new Multi(); // Create thread - t1 - new state
        t1.start(); // Runnable state
        Multi t2 = new Multi();
        t2.start();

        // Main thread
        for(int i = 11; i <= 20; i++){
            System.out.println(i);
        }
    }
}