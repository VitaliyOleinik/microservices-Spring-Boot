package shu_book.chapter_02.bankanalyzer.srp.ocp;

import shu_book.chapter_02.bankanalyzer.srp.BankTransaction;
import shu_book.chapter_02.bankanalyzer.srp.Category;

import java.time.Month;
import java.util.List;

interface BankTransactionProcessor {
    double calculateTotalAmount();
    double calculateTotalInMonth(Month month);
    double calculateTotalInJanuary();
    double calculateAverageAmount();
    double calculateAverageAmountForCategory(Category category);
    List<BankTransaction> findTransactions(BankTransactionFilter bankTransactionFilter);
}