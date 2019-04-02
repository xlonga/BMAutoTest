package ReUtils;

import org.apache.poi.ss.usermodel.*;

import java.io.*;

public class HttpExcelUtils {

    public static Object[][] read(int[] rows,int[] cells) throws FileNotFoundException {


        /**
         * 单个单元格
         */
        InputStream inputStream = new FileInputStream(new  File("src\\main\\resources\\接口测试用例V1.0.xlsx"));
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[][] datas = new Object[rows.length][cells.length];
        Sheet sheet = workbook.getSheet("接口信息");
        for (int i = 0; i < rows.length; i++) {
            Row row = sheet.getRow(rows[i]-1);//行


            for (int j = 0; j < cells.length; j++) {

                Cell cell = row.getCell(cells[j]-1, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                cell.setCellType(CellType.STRING);



                String cellValue =cell.getStringCellValue();
                System.out.println(cellValue);
                datas[i][j] =cellValue;

                if (inputStream !=null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        return datas;









    }








}
