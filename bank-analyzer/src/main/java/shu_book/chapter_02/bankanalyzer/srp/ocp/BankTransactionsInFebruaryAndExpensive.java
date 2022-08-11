package shu_book.chapter_02.bankanalyzer.srp.ocp;

import shu_book.chapter_02.bankanalyzer.srp.BankTransaction;

import java.time.Month;

public class BankTransactionsInFebruaryAndExpensive implements BankTransactionFilter {
    @Override
    public boolean test(BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY
                && bankTransaction.getAmount() >= 1_000;
    }
}
