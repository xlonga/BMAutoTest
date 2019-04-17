package ReUtils;

import org.apache.poi.ss.usermodel.*;

import java.io.*;

public class ReExcelUts {

    public static Object[][] readx(String filepath,String sheetName){

        InputStream inputStream=null;

        try {
            inputStream = new FileInputStream(new File(filepath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet(sheetName);
            int lastRow = sheet.getLastRowNum();

            Row titleRow = sheet.getRow(0);
            int titlelastcell = titleRow.getLastCellNum();
            int lastCellNum = titleRow.getLastCellNum();//列号从1开始，行号从0开始

            String[] titles = new String[lastCellNum];
            //通过循环依此取出标题行地每一列
            for (int i = 0; i < titlelastcell-1; i++) {
                Cell cell = titleRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                cell.setCellType(CellType.STRING);
                String cellValue = cell.getStringCellValue();
                titles[i] = cellValue;
                System.out.println(titles[i]);

            }

            //处理数据行，封装每一行数据为对象







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

        ReExcelUts.readx(filepath,sheetName);

    }
}
