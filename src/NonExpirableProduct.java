public class NonExpirableProduct extends Product implements Shippable {

    private boolean requiresShipping;
    private double weight;

    public NonExpirableProduct(String name, double price, int quantity, boolean requiresShipping, double weight){

        super(name,price,quantity);
        this.requiresShipping = requiresShipping;

        if (requiresShipping) {
            if (weight <= 0) {
                throw new IllegalArgumentException("Weight must be positive for shippable products.");
            }
            this.weight = weight;
        } else {
            if (weight > 0) {
                System.out.println("Non-shippable product '" + name + "' provided with non-zero weight. Weight will be ignored.");
            }
            this.weight = 0;
        }

    }

    @Override
    public boolean isExpired() {
        return false;
    }

    @Override
    public boolean requiresShipping() {
        return requiresShipping;
    }

    @Override
    public double getWeight() {
        if (!requiresShipping) {
            throw new IllegalStateException(getName() + " doesnt require shipping");
        }
        return weight;
    }
}
