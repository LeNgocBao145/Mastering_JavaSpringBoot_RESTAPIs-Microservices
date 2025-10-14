public class Customer {
    private int balance;

    public Customer(int initialBalance){
        this.balance = initialBalance;
    }

    public void getBalance(){
        System.out.println("Current Balance: " + balance);
    }

    public synchronized void withdraw(int amount){
        if(amount > balance){
            System.out.println("Insufficient balance: waiting for deposit...");
            try{
                // releases the lock on 
                // this object and waits
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount);
        getBalance();
    }
        

    public synchronized void deposit(int amount){
        balance += amount;
        System.out.println("Deposited: " + amount);
        // notifies a waiting thread that
        // it can wake up and acquire the lock
        // on this object and proceed
        notify();
        getBalance();
    }
}