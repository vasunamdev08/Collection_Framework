package assignment.q14;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q14 {
    public static void main(String[] args) {
        Deque<Order> currentOrders = new LinkedList<>();

        List<Order> orderHistory = new ArrayList<>();

        // Adding orders
        currentOrders.addLast(new Order("Burger"));       // Add to end
        currentOrders.addFirst(new Order("Pasta"));       // Add to front
        currentOrders.addLast(new Order("Pizza"));

        // Print current queue
        System.out.println("Current Orders:");
        for (Order o : currentOrders) {
            System.out.println(o);
        }

        // Process (remove) orders from both ends and archive them
        System.out.println("\nProcessing Orders:");
        Order firstOut = currentOrders.pollFirst();       // Remove from front
        Order lastOut = currentOrders.pollLast();         // Remove from end
        if (firstOut != null) orderHistory.add(firstOut);
        if (lastOut != null) orderHistory.add(lastOut);
        System.out.println("Processed: " + firstOut);
        System.out.println("Processed: " + lastOut);

        // Remaining current orders
        System.out.println("\nRemaining Orders:");
        for (Order o : currentOrders) {
            System.out.println(o);
        }

        // History of processed orders
        System.out.println("\nOrder History:");
        for (Order o : orderHistory) {
            System.out.println(o);
        }
    }
}
