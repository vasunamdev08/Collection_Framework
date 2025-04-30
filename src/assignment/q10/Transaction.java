package assignment.q10;

import java.time.LocalDateTime;

class Transaction {
    private final LocalDateTime time;
    private final double amount;
    private final String description;

    public Transaction(LocalDateTime time, double amount, String description) {
        this.time = time;
        this.amount = amount;
        this.description = description;
    }

    public LocalDateTime getTime() { return time; }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return time.format(java.time.format.DateTimeFormatter.ofPattern("hh:mm dd/MM/yyyy")) + " - " +
                (amount > 0 ? "Deposit: " : "Withdrawal: ") + Math.abs(amount) + " (" + description + ")";
    }
}
