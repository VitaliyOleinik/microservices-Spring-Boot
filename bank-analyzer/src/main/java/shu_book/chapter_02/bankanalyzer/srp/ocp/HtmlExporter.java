package shu_book.chapter_02.bankanalyzer.srp.ocp;

public class HtmlExporter implements Exporter {
    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "<!doctype html>";
        result += "<html lang='en'>";
        result += "<headxtitle>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong>The sum is</strong>: " + summaryStatistics.getSum()
                + "</li>";
        result += "<li><strong>The average is</strong>: " + summaryStatistics.
                getAverage() + "</li>";
        result += "<li><strong>The max is</strong>: " + summaryStatistics.getMax()
                + "</li>";
        result += "<li><strong>The min is</strong>: " + summaryStatistics.getMin()
                + "</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;

    }
}
