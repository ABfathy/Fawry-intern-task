public abstract class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity){

    }

    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }


    public void reduceQuantity(int quantity) {

        this.quantity -= quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    public abstract boolean isExpired();
    public abstract boolean requiresShipping();


}
