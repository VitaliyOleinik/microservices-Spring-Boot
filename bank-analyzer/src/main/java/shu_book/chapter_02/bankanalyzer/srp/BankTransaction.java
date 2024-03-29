package shu_book.chapter_02.bankanalyzer.srp;

import shu_book.chapter_02.bankanalyzer.srp.ocp.exception.Notification;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public class BankTransaction {
    private final LocalDate date;
    private final double amount;
    private final String description;

    public BankTransaction(final LocalDate date, final double amount, final String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Notification validate() {

        final Notification notification = new Notification();
        if (this.description.length() > 100) {
            notification.addError("The description is too long");
        }

        final LocalDate parseDate;
        try {
            parseDate = LocalDate.parse(this.date.toString());
            if (parseDate.isAfter(LocalDate.now())) {
                notification.addError("date cannot be in the future");
            }
        }
        catch (DateTimeParseException e) {
            notification.addError("Invalid format for date");
        }

        final double amount;

        try {
            amount = Double.parseDouble(String.valueOf(this.amount));
        }
        catch (NumberFormatException e) {
            notification.addError("Invalid format for amount");
        }
        return notification;
    }

    @Override
    public String toString() {
        return "BankTransaction{" +
                "date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                date.equals(that.date) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, description);
    }
}
