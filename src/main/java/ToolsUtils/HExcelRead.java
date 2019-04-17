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

    //读取单个单个的参数
    public static Object[][] Excel_read( int[] rowNum, int[] cellNum ){
        String filePath = "src\\main\\resources\\接口测试用例1V1.0.xlsx";
        InputStream inputStream=null;
        Workbook workbook=null;
        Object[][] datas = new Object[rowNum.length][cellNum.length];
        try {
             inputStream = new FileInputStream(filePath);
             workbook = WorkbookFactory.create(inputStream);
             Sheet sheet = workbook.getSheet("接口信息");
            for (int i = 0; i < rowNum.length; i++) {
                Row row = sheet.getRow(rowNum[i]-1);
                for (int j = 0; j <cellNum.length; j++) {
                   Cell cell = row.getCell(cellNum[j]-1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    cell.setCellType(CellType.STRING);
                    String cellVelanNum = cell.getStringCellValue();
                    System.out.println(cellVelanNum);
                    datas[i][j]=cellVelanNum;

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return datas;
    }


    //Excel 读取升级, 之前读取需要输入行数列数，现在修改读取指定的列，所有的行。
    public static void Exall_read(){



    }

    public static void main(String[] args) {

//       int[] rowNum ={2,3,4,5};
//       int[] cellNum ={6,7};
//        Excel_read(rowNum,cellNum);

        int[] rowNum ={2,3,4,5};
        int[] cellNum ={3,4,6};
        Excel_read(rowNum,cellNum);


    }
}




