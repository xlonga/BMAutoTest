package ReUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CaseUtil {
    public static List<Cases> cases = new ArrayList<Cases>();
    static {
        List<Cases> list = HttpExcelUtils.read2("src\\main\\resources\\接口测试用例V1.0.xlsx","用例");
        cases.addAll(list);
    }

    public static Object[][] datas(){

        //从cases 这个集合去取
        return  null;

    }
}
