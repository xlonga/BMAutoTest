package apicase;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LoginCase1 的整理回顾。
 */


public class LoginCase2 {

    @Test
    public void testcaseByPost(){

        String url ="http://47.104.134.50:8666/ManagementPlatform/Account/Admin/v1.0/PhoneLogin";
        String ACB501="13522352342";
        String UCC003="E10ADC3949BA59ABBE56E057F20F883E";


        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);

        List<BasicNameValuePair> parameters = new ArrayList<BasicNameValuePair>();
        parameters.add(new BasicNameValuePair("ACB501",ACB501));
        parameters.add(new BasicNameValuePair("UCC003",UCC003));

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(parameters,"UTF-8"));
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            int code = httpResponse.getStatusLine().getStatusCode();
            String bodydata = EntityUtils.toString(httpResponse.getEntity());
            String headall = Arrays.toString(httpResponse.getAllHeaders());

            System.out.println("请求响应码"+"【"+code+ "】");
            System.out.println("请求体"+"【"+bodydata+ "】");
            System.out.println("请求头"+"【"+headall+ "】");


            httpResponse.close();


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    };


    @Test
    public void testcaseByGet(){

        String url ="http://47.104.134.50:8666/ManagementPlatform/Authority/Admin/v1.0/ModelList";
        String UCE309A="ea185029d3e349a6afd5b0d9a56a19b1";
        String UCC007="10000001";


        CloseableHttpClient httpClient = HttpClients.createDefault();

        url +=("?UCE309A="+UCE309A+"&UCC007="+UCC007);
        HttpGet httpGet = new HttpGet(url);

        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

            int code = httpResponse.getStatusLine().getStatusCode();
            String bodydata = EntityUtils.toString(httpResponse.getEntity());
            String headall = Arrays.toString(httpResponse.getAllHeaders());

            System.out.println("请求响应码"+"【"+code+ "】");
            System.out.println("请求体"+"【"+bodydata+ "】");
            System.out.println("请求头"+"【"+headall+ "】");


            httpResponse.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    };
}
