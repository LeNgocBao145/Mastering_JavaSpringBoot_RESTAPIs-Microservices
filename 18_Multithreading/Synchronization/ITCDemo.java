public class ITCDemo {
    public static void main(String[] args) {
        Customer customer = new Customer(25000);
        
        new Thread(() -> customer.withdraw(30000)).start();
        new Thread(() -> customer.deposit(10000)).start();
    }
}