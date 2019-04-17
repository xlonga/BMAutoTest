package apicase;

import ReUtils.HttpExcelUtils;
import ReUtils.HttpRequest2;
import Utils.CaseUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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



    @Test (dataProvider = "dd1")
    public void LoginCase2(String daparm){
        String url ="http://47.104.134.50:8666/ManagementPlatform/Account/Admin/v1.0/PhoneLogin";
        //String ACB501="13522352342";
        //String UCC003="E10ADC3949BA59ABBE56E057F20F883E";

        List<BasicNameValuePair> p2arm = new ArrayList<BasicNameValuePair>();
        Map<String,String> sparma = (Map<String, String>) JSONObject.parse(daparm);
        Set<String> keynames = sparma.keySet();
        for (String keyname:keynames){
            String keyValue = sparma.get(keynames);
            p2arm.add(new BasicNameValuePair(keyname,keyValue));

        }

        httpRequest2.do_testByPost(url,p2arm);


    }




    @DataProvider(name = "dd1")
    public Object[][] dd(){
        int[] row ={2,3,4,5};
        int[] cells={8};
     Object[][] datas= HttpExcelUtils.reads(row,cells);
     return datas;
    }


    @DataProvider(name = "d2")
    public Object[][] d2(){
        String filepath="src\\main\\resources\\接口测试用例V1.0.xlsx";
        String sheetName ="用例";
        String [] cellName={"CaseID","Desc","Params"};
        Object[][] datas = CaseUtils.datas(cellName);

        for (Object[] objects:datas){
            System.out.println(objects);
        }
        return datas;
    }







}
