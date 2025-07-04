import java.util.*;
public class CheckoutService {
    private static final double SHIPPING_COST = 30;

    public static void checkout(Customer customer, Cart cart) throws Exception {
        if (cart.isEmpty()) throw new Exception("Cart is empty");

        double subtotal = 0;
        List<Shippable> toShip = new ArrayList<>();

        System.out.println("\nCheckout Receipt");
        System.out.println("----------------------------");

        for (Map.Entry<Product, Integer> e : cart.getItems().entrySet()) {
            Product p = e.getKey();
            int qty = e.getValue();
            double cost = qty * p.getPrice();
            System.out.println("- " + qty + "x " + p.getName() + " = " + (int)cost + " EGP");
            subtotal += cost;

            if (p.requiresShipping() && p instanceof Shippable) {
                for (int i = 0; i < qty; i++) toShip.add((Shippable) p);
            }

            p.reduceQuantity(qty);
        }

        double shippingFee = toShip.isEmpty() ? 0 : SHIPPING_COST;
        double total = subtotal + shippingFee;

        if (!customer.canAfford(total)) throw new Exception("Insufficient balance");

        if (!toShip.isEmpty()) ShippingService.ship(toShip);

        customer.deduct(total);

        System.out.println("----------------------------");
        System.out.println("Subtotal: " + (int)subtotal + " EGP");
        System.out.println("Shipping: " + (int)shippingFee + " EGP");
        System.out.println("Total:    " + (int)total + " EGP");
        System.out.println("Balance Left: " + (int)customer.getBalance() + " EGP");

        cart.clear();
    }
}
