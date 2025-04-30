package assignment.q10;

import java.time.LocalDateTime;
import java.util.*;

public class Q10 {
    public static void main(String[] args) {
        Map<String, List<Transaction>> accountLogs = new HashMap<>();

        // Add some sample transactions
        logTransaction(accountLogs, "ACC123", new Transaction(LocalDateTime.of(2023, 4, 15, 10, 30), 500.0, "Deposit"));
        logTransaction(accountLogs, "ACC123", new Transaction(LocalDateTime.of(2023, 4, 17, 14, 0), -200.0, "Withdrawal"));
        logTransaction(accountLogs, "ACC456", new Transaction(LocalDateTime.of(2023, 4, 16, 9, 15), 300.0, "Deposit"));
        logTransaction(accountLogs, "ACC123", new Transaction(LocalDateTime.of(2023, 4, 16, 11, 45), -50.0, "ATM Fee"));

        // Generate statements
        generateStatement(accountLogs, "ACC123");
        generateStatement(accountLogs, "ACC456");
    }

    private static void logTransaction(Map<String, List<Transaction>> map, String account, Transaction txn) {
        map.computeIfAbsent(account, k -> new ArrayList<>()).add(txn);
    }

    private static void generateStatement(Map<String, List<Transaction>> map, String account) {
        System.out.println("\nStatement for Account: " + account);
        List<Transaction> transactions = map.getOrDefault(account, Collections.emptyList());

        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getTime))
                .forEach(System.out::println);
    }
}
