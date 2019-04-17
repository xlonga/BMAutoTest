package Utils;

import com.sun.org.apache.xpath.internal.operations.Variable;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HHHreEx {

    public static List<Cases> readaaaxx(String filePath, String sheetName, Class<Variable> variableClass){


        List<Cases> list = new ArrayList<Cases>();
        InputStream inputStream=null;
        try {
            inputStream = new FileInputStream(new File(filePath));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet(sheetName);
            int lastRow = sheet.getLastRowNum();
            Row row = sheet.getRow(0);
            int lastcell = row.getLastCellNum();
            String [] titileRow = new String[lastcell];
            String [][] dataCell = new String[lastRow][lastcell];

            for (int i = 0; i <=lastcell-1; i++) {
                Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                cell.setCellType(CellType.STRING);
                String cellValue = cell.getStringCellValue();
                titileRow[i]= cellValue;

            }

            System.out.println(Arrays.toString(titileRow));





            //处理数据行

            for (int i = 1; i <=lastRow; i++) {

                Cases cs =new Cases();
               Row row1 = sheet.getRow(i);
                for (int j = 0; j <=lastcell-1; j++) {
                    Cell cell = row1.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellType(CellType.STRING);
                    String cell1Value = cell.getStringCellValue();
                    String cellName = titileRow[j];
                    cellName =cellName.substring(0,cellName.indexOf("("));
                    String reflectMethodName ="set"+cellName;
                 Method method = Cases.class.getDeclaredMethod(reflectMethodName,String.class);
                 method.invoke(cs,cell1Value);

                }

                list.add(cs);



            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return list;

    }


    public static void main(String[] args) {
        String filepath="src\\main\\resources\\接口测试用例V1.0.xlsx";
        String sheetName ="用例";
        List<Cases> list = HHHreEx.readaaaxx(filepath,sheetName, Variable.class);
        for (Cases cases:list){
            System.out.println(cases);
        }



    }

}
