package shu_book.chapter_02.bankanalyzer.srp;

import shu_book.chapter_02.bankanalyzer.srp.ocp.BankTransactionsInFebruaryAndExpensive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";
    private static final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();

    /*public static void main(String[] args) throws IOException {
        // Сильная связанность
        final String fileName = args[0];
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions
                = bankStatementParser.parseLinesFromCSV(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);

    }*/

    public void analyze(final String fileName, final BankStatementParser bankStatementParser)
            throws IOException {
        // Слабая связанность
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);

        //OCP
        final List<BankTransaction> transactions
                = bankStatementProcessor.findTransactions(new BankTransactionsInFebruaryAndExpensive());
        // лямбда выражение
        final List<BankTransaction> transactions1
            = bankStatementProcessor.findTransactions(bankTransaction ->
                bankTransaction.getDate().getMonth() == Month.FEBRUARY
                && bankTransaction.getAmount() >= 1_000);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transactions is "
                + bankStatementProcessor.calculateTotalAmount());
        System.out.println("Transactions in January "
                + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("Transactions in February "
                + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is"
                + bankStatementProcessor.calculateTotalForCategory("Salary"));

    }

}
