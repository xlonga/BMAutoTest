package ToolsUtils;

import org.apache.http.HttpEntity;
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
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class HrequestUtils {

    /**发送post/get请求类**/



    public static void do_Post(String url,List<BasicNameValuePair>parameter){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpEntity httpEntity = null;
        CloseableHttpResponse httpResponse =null;
        try {
            httpEntity = new UrlEncodedFormEntity(parameter,"UTF-8");
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(httpEntity);

            httpResponse = httpClient.execute(httpPost);

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


    public static void do_Get(String url,List<BasicNameValuePair>parameters)  {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        url += ("?"+ URLEncodedUtils.format(parameters,"UTF-8"));
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse httpResponse =null;

        try {
            httpResponse= httpClient.execute(httpGet);
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
