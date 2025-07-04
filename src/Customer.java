public class Customer {
    private final String name;
    private double balance;

    public Customer(String name, double balance) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("customer name required");
        }
        if (balance < 0){
            throw new IllegalArgumentException("balance cannot be negative");
        }

        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public boolean canAfford(double amount){
        return balance >= amount;
    }

    public void deduct(double amount){
        balance -= amount;
    }

}
