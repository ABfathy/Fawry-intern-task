public abstract class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity){
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("name cant be empty");
        }
        if (price < 0){
            throw new IllegalArgumentException("price cant be below zero");
        }
        if (quantity < 0){
            throw new IllegalArgumentException("quantity cant be negative");
        }

        this.price=price;
        this.name=name;
        this.quantity=quantity;

    }

    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void updatePrice(double newPrice){
        if(newPrice < 0){
            throw new IllegalArgumentException("price cant be below zero");
        }
        this.price = newPrice;
    }

    public void restock(int amount){
        if(amount <= 0 ){
            throw new IllegalArgumentException("Restock amount must be positive");

        }
        this.quantity += amount;
    }

    public void reduceQuantity(int quantity) {
        if(quantity <= 0){
            throw new IllegalArgumentException("quantity is already negative");
        }
        if(this.quantity < quantity){
            throw new IllegalArgumentException("insufficient stock");
        }
        this.quantity -= quantity;
    }

    public boolean isAvailable(int requestedQuantity){
        return this.quantity >= requestedQuantity;

    }

    public abstract boolean isExpired();
    public abstract boolean requiresShipping();


}
