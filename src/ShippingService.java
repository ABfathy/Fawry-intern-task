import java.util.*;
public class ShippingService {
    public static void ship(List<Shippable> shippables) {
        if (shippables.isEmpty()) return;
        System.out.println("\nShipment Notice");
        System.out.println("----------------------------");
        double totalWeight = 0;
        Map<String, Integer> counts = new LinkedHashMap<>();
        Map<String, Double> unitWeight = new HashMap<>();

        for (Shippable s : shippables) {
            counts.put(s.getName(), counts.getOrDefault(s.getName(), 0) + 1);
            unitWeight.putIfAbsent(s.getName(), s.getWeight());
            totalWeight += s.getWeight();
        }

        for (String name : counts.keySet()) {
            int qty = counts.get(name);
            double weightGrams = unitWeight.get(name) * qty * 1000;
            System.out.println("- " + qty + "x " + name + " - " + (int)weightGrams + "g");
        }

        System.out.println("Total Package Weight: " + String.format("%.1f", totalWeight) + " kg\n");
    }
}
