package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.FileContentReader.readDocFile;
import static utils.FileContentReader.readDocxFile;


public class DocxTest {
    @Test
    public void docxTest () throws IOException {
        String path = "src/test/resources/files/1.docx";
        String expectedData = "Hello, qa.guru students !";
        String actualData = readDocxFile(path);
        System.out.println(actualData);
        assertThat(actualData, containsString(expectedData));
        }

    @Test
    public void docTest () throws IOException {
        String path = "src/test/resources/files/2.doc";
        String expectedData = "Hello, qa.guru students !";
        String actualData = readDocFile(path);
        System.out.println(actualData);
        assertThat(actualData, containsString(expectedData));
    }
}


