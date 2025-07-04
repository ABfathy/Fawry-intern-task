import java.util.*;

public class Cart {
    private final Map<Product, Integer> items = new LinkedHashMap<>();

    public void add(Product product, int qty) throws Exception {
        if (qty <= 0) throw new Exception("Quantity must be positive");
        if (!product.isAvailable(qty)) throw new Exception(product.getName() + " out of stock");
        if (product.isExpired()) throw new Exception(product.getName() + " is expired");
        items.put(product, items.getOrDefault(product, 0) + qty);
    }

    public Map<Product, Integer> getItems() { return items; }
    public boolean isEmpty() { return items.isEmpty(); }
    public void clear() { items.clear(); }
}
