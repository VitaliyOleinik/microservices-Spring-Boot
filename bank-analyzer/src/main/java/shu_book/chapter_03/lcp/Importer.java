package shu_book.chapter_03.lcp;

import java.io.File;
import java.io.IOException;

interface Importer {
    Document importFile(File file) throws IOException;
}
