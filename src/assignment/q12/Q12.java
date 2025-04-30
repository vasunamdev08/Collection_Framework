package assignment.q12;

import java.util.*;

public class Q12 {
    public static void main(String[] args) {
        // Sample votes
        List<String> votes = Arrays.asList("Alice", "Bob", "Alice", "Charlie", "Bob", "Bob", "Alice");

        // Tally votes
        Map<String, Integer> voteCounts = new HashMap<>();
        for (String vote : votes) {
            voteCounts.put(vote, voteCounts.getOrDefault(vote, 0) + 1);
        }

        // Sort by vote count descending
        List<Map.Entry<String, Integer>> sortedCandidates = new ArrayList<>(voteCounts.entrySet());
        sortedCandidates.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Print results
        System.out.println("Voting Results:");
        for (Map.Entry<String, Integer> entry : sortedCandidates) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
}
