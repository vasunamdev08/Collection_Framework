package assignment.q9;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Q9 {
    public static void main(String[] args) {
        // Custom comparator: by score descending, then by name
        Comparator<Player> scoreComparator = Comparator
                .comparingInt(Player::getScore).reversed()
                .thenComparing(Player::getName);

        TreeSet<Player> leaderboard = new TreeSet<>(scoreComparator);

        // Add players
        addPlayer(leaderboard, new Player("Alice", 120));
        addPlayer(leaderboard, new Player("Bob", 150));
        addPlayer(leaderboard, new Player("Charlie", 100));

        // Print initial leaderboard
        System.out.println("Initial Leaderboard:");
        printLeaderboard(leaderboard);

        // Update a player's score
        updateScore(leaderboard, "Alice", 160);

        // Print updated leaderboard
        System.out.println("\nUpdated Leaderboard:");
        printLeaderboard(leaderboard);
    }

    private static void addPlayer(Set<Player> leaderboard, Player player) {
        leaderboard.add(player);
    }

    private static void updateScore(Set<Player> leaderboard, String name, int newScore) {
        Player dummy = new Player(name, 0); // Needed to locate the existing player

        for (Player p : leaderboard) {
            if (p.equals(dummy)) {
                leaderboard.remove(p);
                p.setScore(newScore);
                leaderboard.add(p);
                break;
            }
        }
    }

    private static void printLeaderboard(Set<Player> leaderboard) {
        for (Player p : leaderboard) {
            System.out.println(p);
        }
    }
}
