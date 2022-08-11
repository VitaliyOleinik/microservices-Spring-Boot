package shu_book.chapter_02.bankanalyzer.srp;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
