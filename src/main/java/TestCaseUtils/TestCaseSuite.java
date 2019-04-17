package TestCaseUtils;

import ToolsUtils.HrequestUtils;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import static ToolsUtils.HExcelRead.Excel_read;

public class TestCaseSuite {
    /**
     * 测试用例编写地方
     */


    @Test
    public static void test_IDCardDetail(){
        String url ="http://47.104.134.50:8666/ManagementPlatform/BasicInformation/Person/Authentication/v1.0/IDCardDetail";
        String AAC002="429006199602026060";
        String AAC003="郑春";
        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
        parameters.add(new BasicNameValuePair("AAC002",AAC002));
        parameters.add(new BasicNameValuePair("AAC003",AAC003));

        HrequestUtils.do_Get(url,parameters);
    };


    @Test(dataProvider = "d1")
    public static void test_Login(String ACB501,String UCC003  ){
        String url ="http://47.104.134.50:8666/ManagementPlatform/Account/Admin/v1.0/PhoneLogin";
        List<BasicNameValuePair> parameter = new ArrayList<BasicNameValuePair>();
        parameter.add(new BasicNameValuePair("ACB501",ACB501));
        parameter.add(new BasicNameValuePair("UCC003",UCC003));
        HrequestUtils.do_Post(url,parameter);

    };



    @DataProvider(name = "d1")
    public Object[][] case_datas(){



        Object[][] case_datas ={
                {"13522352342","E10ADC3949BA59ABBE56E057F20F883E"},
                {"","E10ADC3949BA59ABBE56E057F20F883E"},
                {"13522352342","E10ADfC3949BA59ABBE56E057F20F883E"},
                {"13522352342",""}
        };
        return case_datas;
    }
}
