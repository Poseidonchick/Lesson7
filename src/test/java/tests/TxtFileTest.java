package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.FileContentReader.readTextFromPath;

public class TxtFileTest {
    @Test
    void txtTest() throws IOException {
        String txtFilePath = "src/test/resources/files/1.text";
        String expectedData = "hello qa.guru students !";
        String actualData = readTextFromPath(txtFilePath);
        assertThat(actualData, containsString(expectedData));
    }
}
