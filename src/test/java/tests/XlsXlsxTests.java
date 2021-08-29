package tests;

import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.FileContentReader.getXlsFileFromPath;

public class XlsXlsxTests {
    @Test
    public void xlsXlsxTest() throws IOException {
        String xlsFilePath = "src/test/resources/files/1.xls";
        String xlsxFilePath = "src/test/resources/files/1.xlsx";
        String expectedData = "hello qa.guru students !";
        XLS xls = getXlsFileFromPath(xlsFilePath);
        XLS xlsx = getXlsFileFromPath(xlsxFilePath);
        assertThat(xls, XLS.containsText(expectedData));
        assertThat(xlsx, XLS.containsText(expectedData));
    }

    @Test
    public void xlsCellsTest() throws IOException {
        String xlsFilePath = "src/test/resources/files/1.xls";
        String expectedData = "hello qa.guru students !";
        XLS xls = getXlsFileFromPath(xlsFilePath);
        String actualData = xls.excel.getSheetAt(0).getRow(0).getCell(0).toString();
        assertThat(actualData, containsString(expectedData));
        System.out.println(actualData);
    }
}