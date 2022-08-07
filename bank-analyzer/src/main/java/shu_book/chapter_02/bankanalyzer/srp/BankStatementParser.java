package shu_book.chapter_02.bankanalyzer.srp;

import java.util.List;

public interface BankStatementParser {
    BankTransaction parserFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
