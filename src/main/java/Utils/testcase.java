package Utils;

import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class testcase {

    public static void main(String[] args) throws IOException {

        String url ="http://47.104.134.50:8666/ManagementPlatform/Account/Admin/v1.0/PhoneLogin";
        String ACB501="13522352342";
        String UCC003="E10ADC3949BA59ABBE56E057F20F883E";
        String charset ="UTF-8";

        List<BasicNameValuePair> parpost =new ArrayList<BasicNameValuePair>();
        parpost.add(new BasicNameValuePair("ACB501",ACB501));
        parpost.add(new BasicNameValuePair("UCC003",UCC003));
        requestUtils aa = new requestUtils();
        try {
            aa.doByPost(url,parpost,charset);
        } catch (IOException e) {
            e.printStackTrace();
        }


        String url_2="http://47.104.134.50:8666/ManagementPlatform/Authority/Admin/v1.0/ModelList";
        String UCE309A="ea185029d3e349a6afd5b0d9a56a19b1";
        String UCC007="10000001";

        List<BasicNameValuePair> parget= new ArrayList<BasicNameValuePair>();
        parget.add(new BasicNameValuePair("UCE309A",UCE309A));
        parget.add(new BasicNameValuePair("UCC007",UCC007));
        aa.doByGet(url_2,parget,charset);


    }
}
