package ReUtils;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
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

public class HttpRequestUtils {

    public  void test2ByPost(String url,List<BasicNameValuePair> parameter4){

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(parameter4,"UTF-8"));
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

    public  void test2ByGet(String url,List<BasicNameValuePair> pap2){

        String pa =  URLEncodedUtils.format(pap2,"UTF-8");
        url += ("?"+pa);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse httpResponse =httpClient.execute(httpGet);
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
