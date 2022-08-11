package shu_book.chapter_02.bankanalyzer.srp.ocp;

import shu_book.chapter_02.bankanalyzer.srp.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
