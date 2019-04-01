package Utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class reExcelUtils {

    public static void main(String[] args) throws IOException {
       InputStream inputStream = new FileInputStream(new File("src\\main\\resources\\接口测试用例V1.0.xlsx"));

       Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheet("接口信息");



    }
}
