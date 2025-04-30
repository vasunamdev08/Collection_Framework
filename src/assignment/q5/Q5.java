package assignment.q5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Q5 {
    public static void main(String[] args) {
        TreeMap<Integer, Product> productMap = new TreeMap<>();

        // Add sample products
        productMap.put(101, new Product(101, "Laptop", 999.99, 4.5, 10));
        productMap.put(102, new Product(102, "Smartphone", 699.99, 4.7, 25));
        productMap.put(103, new Product(103, "Headphones", 199.99, 4.7, 50));
        productMap.put(104, new Product(104, "Keyboard", 49.99, 4.3, 100));
        productMap.put(105, new Product(105, "Monitor", 229.99, 4.5, 30));

        // Extract values and sort
        List<Product> sortedProducts = new ArrayList<>(productMap.values());

        sortedProducts.sort(
                Comparator.comparingDouble(Product::getRating).reversed()
                        .thenComparing(Product::getName)
        );

        // Print sorted products
        System.out.println("Sorted Product Catalog:");
        sortedProducts.forEach(System.out::println);
    }
}
