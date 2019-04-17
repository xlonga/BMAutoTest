package Utils;

import com.sun.org.apache.xpath.internal.operations.Variable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

public  class CaseUtils {
    public static List<Cases> cases = new ArrayList<Cases>();

    //数据加载，一次读取excel所有数据，每条数据封装为对象。
    static {
        String filepath="src\\main\\resources\\接口测试用例V1.0.xlsx";
        String sheetName ="用例";
       List<Cases> list = (List<Cases>) HHHreEx.readaaaxx(filepath,sheetName, Variable.class);
        cases.addAll(list);

    }

    //筛选数据 从cases集合筛选数据
    public static Object[][] datas (String[] cellNames){

        List<Cases>statisfied= new ArrayList<Cases>();
        int rows = cases.size();
        int cells = cellNames.length;
        Object[][] datas = new Object[rows][cells];

        for (int i = 0; i < cases.size(); i++) {
            //依次取出每个对象


            Cases cs = cases.get(i);
            for (int j = 0; j < cells; j++) {

                //类名
                String cellName = cellNames[j];

                //反射 方法名
                String reflectMethodName ="get"+cellName;

                try {
                   Method method = Cases.class.getDeclaredMethod(reflectMethodName);

                    String value =(String) method.invoke(cs);
                    datas[i][j]=value;
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }


            }

        }


        return datas;
    }


    public static void main(String[] args) {
        String[] cellNmaes={"ApiID","CaseID","Desc","Params"};
        Object[][] datas1 = CaseUtils.datas(cellNmaes);
//        for (int i = 0; i < cellNmaes.length; i++) {
//            String cellNmae = cellNmaes[i];
//            String methodNmae = "get"+cellNmae;
//            System.out.println(methodNmae);
//
//        }


        for (Object[] objects: datas1) {
            System.out.println(Arrays.toString(objects));

       }
    }



}
