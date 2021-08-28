package tests;

import com.codeborne.selenide.Configuration;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.FileContentReader.readFileContent;

public class DownloadFileTests {
    @Test
    void selenideReadmeTest() throws IOException {
        Configuration.downloadsFolder = "downloads";
        open("https://github.com/selenide/selenide/blob/master/README.md");
        File downloadedFile = $("#raw-url").download();
        String fileContent = readFileContent(downloadedFile);
        System.out.println(fileContent);
        assertTrue(fileContent.contains("# Selenide = UI Testing Framework powered by Selenium WebDriver"));
        assertThat(fileContent, Matchers.containsString("# Selenide = UI Testing Framework powered by Selenium WebDriver"));
    }
}