import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            Product cheese      = new ExpirableProduct("feta cheese", 100, 5, LocalDate.now().plusDays(3), 0.2);
            Product biscuits    = new ExpirableProduct("biscuits", 150, 3, LocalDate.now().plusDays(2), 0.7);
            Product tv          = new NonExpirableProduct("Tv", 3000, 2, true, 10.0);
            Product scratchCard = new NonExpirableProduct("Scratch Card", 50, 100, false, 0);

            Customer customer = new Customer("Abdallah", 1000);
            Cart cart = new Cart();

            cart.add(cheese, 2);
            cart.add(biscuits, 1);
            cart.add(scratchCard, 1);

            CheckoutService.checkout(customer, cart);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}