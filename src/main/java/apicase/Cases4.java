package apicase;

import ReUtils.HttpExcelUtils;
import ReUtils.HttpRequest2;
import ReUtils.HttpRequestUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cases4 {

    public static HttpRequest2 httpRequest2 = new HttpRequest2();



    @Test
    public void LoginCase(){
        String url ="http://47.104.134.50:8666/ManagementPlatform/Account/Admin/v1.0/PhoneLogin";
        String ACB501="13522352342";
        String UCC003="E10ADC3949BA59ABBE56E057F20F883E";

        List<BasicNameValuePair> p2arm = new ArrayList<BasicNameValuePair>();
        p2arm.add(new BasicNameValuePair("ACB501",ACB501));
        p2arm.add(new BasicNameValuePair("UCC003",UCC003));

        httpRequest2.do_testByPost(url,p2arm);


    }


    @Test
    public void  IDCardDetail(){
        String url ="http://47.104.134.50:8666/ManagementPlatform/BasicInformation/Person/Authentication/v1.0/IDCardDetail";
        String AAC002="429006199602026060";
        String AAC003="郑春";

        List<BasicNameValuePair> pap2 = new ArrayList<BasicNameValuePair>();
        pap2.add(new BasicNameValuePair("AAC002",AAC002));
        pap2.add(new BasicNameValuePair("AAC003",AAC003));

        httpRequest2.do_testByGost(url,pap2);


    }

    @DataProvider
    public Object[][] datas(){
        Object[][] datas = {
                {"13522352342","E10ADC3949BA59ABBE56E057F20F883E"},
                {"","E10ADC3949BA59ABBE56E057F20F883E"},
                {"13522352342",""}
        };
        return datas;
    }



    @Test (dataProvider = "d1")
    public void LoginCase2(String ACB051,String UCC003){
        String url ="http://47.104.134.50:8666/ManagementPlatform/Account/Admin/v1.0/PhoneLogin";
        //String ACB501="13522352342";
        //String UCC003="E10ADC3949BA59ABBE56E057F20F883E";

        List<BasicNameValuePair> p2arm = new ArrayList<BasicNameValuePair>();
        p2arm.add(new BasicNameValuePair("ACB501",ACB051));
        p2arm.add(new BasicNameValuePair("UCC003",UCC003));

        httpRequest2.do_testByPost(url,p2arm);


    }
    @DataProvider(name = "d1")
    public Object[][]  testexceldata() throws FileNotFoundException {
        int[] rows ={2,3,4,5};
        int[] cells ={6};
        Object[][] testexceldata = HttpExcelUtils.read(rows,cells);
       //System.out.println(testexceldata.toString());

        return testexceldata;
    }



    @Test (dataProvider = "d1")
    public void LoginCase3(String parametsJson){
        String url ="http://47.104.134.50:8666/ManagementPlatform/Account/Admin/v1.0/PhoneLogin";
        //String ACB501="13522352342";
        //String UCC003="E10ADC3949BA59ABBE56E057F20F883E";

        List<BasicNameValuePair> p2arm = new ArrayList<BasicNameValuePair>();

        Map<String,String> jsonMap =(Map<String, String>) JSONObject.parse(parametsJson);
        Set<String> paramNames = jsonMap.keySet();//获取所有的key
        for (String paramName:paramNames){
           String paramValue = jsonMap.get(paramName);//通过key获取名
         p2arm.add(new  BasicNameValuePair(paramName,paramValue));
        }

//
//        p2arm.add(new BasicNameValuePair("ACB501",ACB051));//属于硬编码
//        p2arm.add(new BasicNameValuePair("UCC003",UCC003));

        httpRequest2.do_testByPost(url,p2arm);


    }








}
