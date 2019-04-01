package ReUtils;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HttpExcelUtils {

    public static void main(String[] args) throws IOException {


        /**
         * 单个单元格
         */
        InputStream inputStream = new FileInputStream(new  File("src\\main\\resources\\接口测试用例V1.0.xlsx"));
        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheet("接口信息");
//        Row row = sheet.getRow(1);
//
//        Cell cell = row.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
//        cell.setCellType(CellType.STRING);
//        String cellValue = cell.getStringCellValue();
//        System.out.println(cellValue);


    }


    /**
     *  指定多个单元格
     *
     */






}
