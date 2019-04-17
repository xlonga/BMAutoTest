package ToolsUtils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class HExcelRead {

    /**
     * 用来读取Excel 做数据驱动 返回Object[][] 类型数据。
     */

    public static Object[][] Excel_read( int rowstartN,int rosendN ,int[] cellNum ){
        String filePath = "src\\main\\resources\\接口测试用例1V1.0.xlsx";
        InputStream inputStream=null;
        Workbook workbook=null;
        Object[][] datas = new Object[rosendN-rowstartN+1][cellNum.length];
        try {
             inputStream = new FileInputStream(filePath);
             workbook = WorkbookFactory.create(inputStream);
             Sheet sheet = workbook.getSheet("接口信息");



            for (int i = 2; i <= 4; i++) {
                Row row = sheet.getRow(i-1);
                int lastCellNum = row.getLastCellNum();
                for (int j = 0; j <=2; j++) {

                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellType(CellType.STRING);
                    String cellVelanNum = cell.getStringCellValue();
                    datas[i][j] =cellVelanNum;


                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return datas;


    }

    public static void main(String[] args) {

        int rowstartN=2;
        int rosendN=5;
        int[]cellNum ={6,7};
        Excel_read(rowstartN,rosendN,cellNum);
    }
}




