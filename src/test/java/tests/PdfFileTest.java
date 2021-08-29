package tests;


import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.pdftest.PDF.containsText;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.FileContentReader.getPdfFileFromPath;

public class PdfFileTest {
    @Test
    public void pdfTest() throws IOException {
        String pdfFilePath = "src/test/resources/files/1.pdf";
        String expectedData = "Как скачать файл с помощью Selenide\n";
        PDF pdf = getPdfFileFromPath(pdfFilePath);
        assertThat(pdf, containsText(expectedData));
    }
}
