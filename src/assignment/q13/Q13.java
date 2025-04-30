package assignment.q13;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q13 {
    public static void main(String[] args) {
        Queue<String> bookingQueue = new LinkedList<>();
        bookingQueue.add("Alice");
        bookingQueue.add("Bob");
        bookingQueue.add("Charlie");

        // Confirmed bookings map: Passenger -> Seat Number
        Map<String, String> confirmedBookings = new LinkedHashMap<>();

        int seatCounter = 1;

        while (!bookingQueue.isEmpty()) {
            String passenger = bookingQueue.poll(); // FIFO
            String seatNumber = "Seat-" + seatCounter++;
            confirmedBookings.put(passenger, seatNumber);
            System.out.println("Confirmed booking: " + passenger + " -> " + seatNumber);
        }

        // Print all confirmed bookings
        System.out.println("\nFinal Confirmed Bookings:");
        for (Map.Entry<String, String> entry : confirmedBookings.entrySet()) {
            System.out.println(entry.getKey() + " is assigned to " + entry.getValue());
        }
    }
}
