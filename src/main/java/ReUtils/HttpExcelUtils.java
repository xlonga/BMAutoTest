package ReUtils;


import org.apache.poi.ss.usermodel.*;

import java.io.*;

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

}





