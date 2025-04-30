package assignment.q7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q7 {
    public static void main(String[] args) {
        Map<String, List<Integer>> ratingsMap = new HashMap<>();

        // Sample ratings
        addRating(ratingsMap, "Inception", 5);
        addRating(ratingsMap, "Inception", 4);
        addRating(ratingsMap, "Interstellar", 5);
        addRating(ratingsMap, "Interstellar", 5);
        addRating(ratingsMap, "The Matrix", 4);
        addRating(ratingsMap, "The Matrix", 3);
        addRating(ratingsMap, "The Matrix", 5);

        // Compute average ratings and sort by average descending
        List<Map.Entry<String, Double>> averageRatings = ratingsMap.entrySet().stream()
                .map(entry -> Map.entry(entry.getKey(), calculateAverage(entry.getValue())))
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toList());

        // Display results
        System.out.println("Movie Ratings (Highest First):");
        for (Map.Entry<String, Double> entry : averageRatings) {
            System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue());
        }
    }

    private static void addRating(Map<String, List<Integer>> map, String movie, int rating) {
        map.computeIfAbsent(movie, k -> new ArrayList<>()).add(rating);
    }

    private static double calculateAverage(List<Integer> ratings) {
        return ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }
}
