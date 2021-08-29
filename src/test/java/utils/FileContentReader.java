package utils;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileContentReader {
    // распарсить файл в строку
    public static String readFileContent(File file) throws IOException {
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }

    // указать путь к файлу
    public static File getFileFromPath(String path) {
        return new File(path);
    }

    // взять текстовый файл из указанного пути и распарсить в строку
    public static String readTextFromPath(String path) throws IOException {
        return readFileContent(getFileFromPath(path));
    }

    // взять ПДФ файл по указанному пути и распарсить в строку
    public static PDF getPdfFileFromPath(String path) throws IOException {
        return new PDF(getFileFromPath(path));
    }

    // взять xls файл по указанному пути и распарсить в строку
    public static XLS getXlsFileFromPath(String path) throws IOException {
        return new XLS(getFileFromPath(path));
    }

    // взять doc файл по указанному пути и распаковать его
    public static void getZipFileFromPath(String zipFilePath, String password, String unzipFolderPath) throws IOException {
        try {
            ZipFile zipFile = new ZipFile(getFileFromPath(zipFilePath));
            if (zipFile.isEncrypted()) {
                zipFile.setPassword(password);
            }
            zipFile.extractAll(unzipFolderPath);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }

    // Вернуть текст файла docx
    public static String readDocxFile(String path) throws IOException {
        FileInputStream inputStream = new FileInputStream(getFileFromPath(path));
        XWPFDocument docx = new XWPFDocument(inputStream);
        XWPFWordExtractor extractor = new XWPFWordExtractor(docx);
        String docsText = extractor.getText();
        return docsText;
    }
    //Вернуть текст файла doc
    public static String readDocFile (String path) throws IOException {
        FileInputStream inputStream = new FileInputStream(getFileFromPath(path));
        HWPFDocument doc = new HWPFDocument(inputStream);
        WordExtractor extractor = new WordExtractor(doc);
        String docsText = extractor.getText();
        return docsText;
    }
}

