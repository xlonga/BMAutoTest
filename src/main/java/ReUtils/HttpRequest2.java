package ReUtils;

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

public class HttpRequest2 {


    public void  do_testByPost(String url, List<BasicNameValuePair> parameters){

        CloseableHttpClient httpClient= HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(parameters,"UTF-8"));
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

    public void  do_testByGost(String url, List<BasicNameValuePair> parameters){

        CloseableHttpClient httpClient= HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        url += ("?"+ URLEncodedUtils.format(parameters,"UTF-8"));
        HttpGet httpGet = new HttpGet(url);
        try {
            httpResponse = httpClient.execute(httpGet);
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
