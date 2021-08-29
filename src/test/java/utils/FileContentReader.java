package utils;

import com.codeborne.pdftest.PDF;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileContentReader {
    // распарсить файл в строку
    public static String readFileContent(File file) throws IOException {
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }
    // указать путь к файлу
    public static File getFileFromPath(String path){
        return new File(path);
    }
    // взять файл из указанного пути и распарсить в строку
    public static String readTextFromPath (String path) throws IOException {
        return readFileContent(getFileFromPath(path));
    }
    // взять ПДФ файл по указанному пути и распарсить в строку
    public static PDF getPdfFileFromPath(String path) throws IOException {
       return new PDF (getFileFromPath(path));
    }
}