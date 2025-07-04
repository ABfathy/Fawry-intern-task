import java.time.LocalDate;
public class ExpirableProduct extends Product implements Shippable{
    private LocalDate expiryDate;
    private double weight;
    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight){

        super(name,price,quantity);
        if (expiryDate == null || expiryDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("expiry date must be in the future");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("weight must be positive");
        }
        this.expiryDate = expiryDate;
        this.weight = weight;

    }

    public LocalDate getExpiryDate(){
        return expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(getExpiryDate());
    }

    @Override
    public boolean requiresShipping() {
        return true;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
