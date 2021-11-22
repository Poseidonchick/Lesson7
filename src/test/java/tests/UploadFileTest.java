package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.FileContentReader.getFileFromPath;

public class UploadFileTest {
    @Test
    public void uploadFileTest(){
        open("https://the-internet.herokuapp.com/upload");
        $("input[type='file']").uploadFile(getFileFromPath("src/test/resources/files/1.text"));
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(text("1.text"));

    }
}
