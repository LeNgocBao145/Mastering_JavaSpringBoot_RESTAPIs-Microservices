class Multi extends Thread{
    public void run(){
        for(int i = 1; i <= 10; i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Multi t1 = new Multi();
        t1.start();
        Multi t2 = new Multi();
        t2.start();

        for(int i = 11; i <= 20; i++){
            System.out.println(i);
        }
    }
}