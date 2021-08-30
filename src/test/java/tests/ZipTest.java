package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.FileContentReader.getZipFileFromPath;
import static utils.FileContentReader.readTextFromPath;

public class ZipTest {
    @Test
    public void zipTest() throws IOException {
        String zipFilePath = "src/test/resources/files/2.zip";
        String unzipFolderPath = "src/test/resources/files/unzip";
        String expectedData = "hello qa.guru students !";
        getZipFileFromPath(zipFilePath, null, unzipFolderPath);
        String actualData = readTextFromPath(unzipFolderPath+"/2.text");
        assertThat(actualData, containsString(expectedData));
    }
}
