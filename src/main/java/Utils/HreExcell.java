package Utils;

import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.Arrays;

public class HreExcell {


    public static Object[][] readxxx(String filepath,String sheetName){

        InputStream inputStream =null;

        try {
            inputStream = new FileInputStream(new File(filepath));

            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheet(sheetName);

            int lastRowNum = sheet.getLastRowNum();
           int lastCellNum = sheet.getRow(0).getLastCellNum();

            String[] titlecell = new String[lastCellNum];
                Row row = sheet.getRow(0);
            for (int i = 0; i < lastCellNum; i++) {
                Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                cell.setCellType(CellType.STRING);
                titlecell[i]= cell.getStringCellValue();

            }

            System.out.println(Arrays.toString(titlecell));



            //读取数据

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        String filepath="src\\main\\resources\\接口测试用例V1.0.xlsx";
        String sheetName ="用例";
        HreExcell.readxxx(filepath,sheetName);

    }

}
