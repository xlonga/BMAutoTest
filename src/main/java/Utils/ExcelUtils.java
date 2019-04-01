package Utils;


import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.*;

/**
 * Excel 读写工具类
 */
public class ExcelUtils {


    public static Object[][] readExcel(int[] rows,int[] cells,String filePath) throws IOException {

        /**
        1.创建workbook对象
         2.获取表单对象sheet
         3.通过sheet对象获取到要操作的行row
         4.通过row去获取要操作的列对象cell
         */

        //src\main\resources\接口测试用例V1.0.xlsx
        InputStream inputStream=null;
        try {
            inputStream = new FileInputStream(new File(filePath));
            Workbook workbook =  WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet("接口信息");

            Object[][] datas = new Object[rows.length][cells.length];
            for (int i = 0; i < rows.length; i++) {
                Row row = sheet.getRow(i-1);
                for (int j = 0; j < cells.length; j++) {
                    Cell cell = row.getCell(j-1);
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue();
                    System.out.println(value);

                }

            }
//            Row row =sheet.getRow(1);
//            Cell cell =row.getCell(5);
            //把单元个数据类型设置为string类型
//            cell.setCellType(CellType.STRING);
//            String value = cell.getStringCellValue();
//            System.out.println(value);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream !=null){
                inputStream.close();
            }
        }
        return null;

    };

    @DataProvider(name = "d1")
    public  Object[][] datas() throws IOException {
        int [] rows = {1,2,3,4};
        int [] cells ={2,3,4,5};
        String filepath="src\\main\\resources\\接口测试用例V1.0.xlsx";
        Object [][] datas =null;

        ExcelUtils.readExcel(rows,cells,filepath);
        return datas;
    }
}
