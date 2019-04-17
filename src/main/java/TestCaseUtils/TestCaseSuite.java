package TestCaseUtils;

import TestConfigUtils.TreadConfig;
import ToolsUtils.HrequestUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static ToolsUtils.HExcelRead.Excel_read;

public class TestCaseSuite {
    /**
     * 测试用例编写地方
     */


    @Test
    //参数没有解耦
    public static void test_IDCardDetail(){
        String url ="http://47.104.134.50:8666/ManagementPlatform/BasicInformation/Person/Authentication/v1.0/IDCardDetail";
        String AAC002="429006199602026060";
        String AAC003="郑春";
        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
        parameters.add(new BasicNameValuePair("AAC002",AAC002));
        parameters.add(new BasicNameValuePair("AAC003",AAC003));

        HrequestUtils.do_Get(url,parameters);
    }


    @Test
    //参数没有解耦,传递的是单个单个参数
    public static void test_Login_1(String ACB501,String UCC003,String type  ){
        String url ="http://47.104.134.50:8666/ManagementPlatform/Account/Admin/v1.0/PhoneLogin";
        List<BasicNameValuePair> parameter = new ArrayList<BasicNameValuePair>();
        parameter.add(new BasicNameValuePair("ACB501",ACB501));
        parameter.add(new BasicNameValuePair("UCC003",UCC003));

        if ("post".equalsIgnoreCase(type)) {
            HrequestUtils.do_Post(url, parameter);
        }else if ("get".equalsIgnoreCase(type)){
            HrequestUtils.do_Get(url,parameter);

        }
    }

    @Test(dataProvider = "d1")
    //参数升级，读取json类型参数, 然后转换为list + 判断是表单新式提交 还是json新式数据提交
    public static void test_Login_2(String methodPath,String type,String jsonparameters){
        String url ="http://47.104.134.50:8666/"+methodPath;
        String contentType = TreadConfig.properties.getProperty("api.content.type.form ");

        //json格式类型的参数，转换为Map类型的参数部分可以提取出来，
        //判断是表单形式提交
        if ("form".equalsIgnoreCase(contentType)){
            List<BasicNameValuePair> parameter = new ArrayList<BasicNameValuePair>();
            //json类型的参数转换为map<>
            Map<String,String> jsonMap = (Map<String, String>) JSONObject.parse(jsonparameters);
            //获取key
            Set<String> paramNames = jsonMap.keySet();
            for (String paramName:paramNames){
                //根据获取的key 获取值
                String paramValue =jsonMap.get(paramName);
                //把值转换为list类型
                parameter.add(new BasicNameValuePair(paramName,paramValue));
            }
            if ("post".equalsIgnoreCase(type)) {
                HrequestUtils.do_Post(url, parameter);
            }else if ("get".equalsIgnoreCase(type)){
                HrequestUtils.do_Get(url,parameter);

            }

            //判断是以json格式提交
        }else if ("json".equalsIgnoreCase(contentType)){
            if ("post".equalsIgnoreCase(type)){
                HrequestUtils.doPost_Byjson(url,jsonparameters);
            }else if ("get".equalsIgnoreCase(type)){
                HrequestUtils.doPost_Byjson(url,jsonparameters);
            }
        }




 //       List<BasicNameValuePair> parameter = new ArrayList<BasicNameValuePair>();
//        parameter.add(new BasicNameValuePair("ACB501",ACB501));
//        parameter.add(new BasicNameValuePair("UCC003",UCC003));



    }



    @Test
    //使用fastjson解析json类型的参数，验证json格式的参数传递
    public static void test_IDCardDetail_2(){
        String url ="http://47.104.134.50:8666/ManagementPlatform/BasicInformation/Person/Authentication/v1.0/IDCardDetail";
//        String AAC002="429006199602026060";
//        String AAC003="郑春";
        String jsonstring ="{\"AAC002\":\"429006199602026060\",\"AAC003\":\"郑春\"}";
        Map<String,String> jsonmap = (Map<String, String>) JSONObject.parse(jsonstring);
        String AAC002 = jsonmap.get("AAC002");
        String AAC003 = jsonmap.get("AAC003");
        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
        parameters.add(new BasicNameValuePair("AAC002",AAC002));
        parameters.add(new BasicNameValuePair("AAC003",AAC003));
        HrequestUtils.do_Get(url,parameters);
    }




    @DataProvider(name = "d1")
    public Object[][] case_datas(){
        int[] rowNum ={2,3,4,5};
        int[] cellNum ={3,4,6};
        Object[][] case_datas =Excel_read(rowNum,cellNum);

//        Object[][] case_datas ={
//                {"13522352342","E10ADC3949BA59ABBE56E057F20F883E"},
//                {"","E10ADC3949BA59ABBE56E057F20F883E"},
//                {"13522352342","E10ADfC3949BA59ABBE56E057F20F883E"},
//                {"13522352342",""}
//        };
        return case_datas;
    }
}
