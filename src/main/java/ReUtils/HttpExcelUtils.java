package ReUtils;


import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class HttpExcelUtils {

    public static Object[][] reads(int[] rows, int[] cells) {


        /**
         * 单个单元格
         */
        InputStream inputStream = null;
        Workbook workbook = null;
        Object[][] datas = new Object[rows.length][cells.length];
        try {
            inputStream = new FileInputStream(new File("src\\main\\resources\\接口测试用例V1.0.xlsx"));
            workbook = WorkbookFactory.create(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = workbook.getSheet("接口信息");

        for (int i = 0; i < rows.length; i++) {
            Row row = sheet.getRow(rows[i] - 1);
            for (int j = 0; j < cells.length; j++) {
                //解决单元格为空的问题
                Cell cell = row.getCell(cells[j]-1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                cell.setCellType(CellType.STRING);
                String data = cell.getStringCellValue();
                datas[i][j] = data;


            }

        }

        return datas;

    }




    public static List<Cases> read2(String  filepath, String sheetName)  {


        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(filepath);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet(sheetName);


           // sheet.getLastRowNum();//表单最后一行 行号
            int lastRownum = sheet.getLastRowNum();
            //处理标题行
            Row titleRow =sheet.getRow(0);
            //titleRow.getLastCellNum();//根据行取这行最后一列地 列号
            int lastCellNum = titleRow.getLastCellNum();//列号从1开始，行号从0开始
            String[] titles = new String[lastCellNum];
            for (int i = 0; i < lastCellNum-1 ;i++) {
                Cell cell = titleRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                cell.setCellType(CellType.STRING);
                String cellValue = cell.getStringCellValue();
                titles[i] =cellValue;

            }

            //处理数据行(从非标题行开始到左后一行)
            for (int i = 0; i <=lastRownum; i++) {

                //每次创建一个CASE对象
                Cases cs = new Cases();
               Row dataRow = sheet.getRow(i);
               //循环处理每一行上地所有列
                for (int j = 0; j <=lastCellNum-1; j++) {
                    Cell cell = dataRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellType(CellType.STRING);
                    String cellValue = cell.getStringCellValue();
                    String cellName = titles[j];
                    cellName.substring(0,cellName.indexOf("("));
                    String reflectMethodName ="set"+cellName;
                  Method method = Cases.class.getDeclaredMethod(reflectMethodName,String.class);
                  method.invoke(cs,cellValue);


                }

            }




        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }


}





