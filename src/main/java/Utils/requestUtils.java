package Utils;


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
import java.util.Arrays;
import java.util.List;


//以表单方式提交
public class requestUtils {
    public void doByPost(String url , List<BasicNameValuePair> parameters, String charset) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        CloseableHttpResponse httpResponse = null;
            try {
            httpPost.setEntity(new UrlEncodedFormEntity(parameters,charset));
             httpResponse =httpClient.execute(httpPost);
            int code = httpResponse.getStatusLine().getStatusCode();
            String bodydata = EntityUtils.toString(httpResponse.getEntity());
            String headall = Arrays.toString(httpResponse.getAllHeaders());
            System.out.println("请求响应码"+"【"+code+ "】");
            System.out.println("请求体"+"【"+bodydata+ "】");
            System.out.println("请求头"+"【"+headall+ "】");
        }
        finally {
            if (httpResponse !=null){
                httpResponse.close();
            }
            httpClient.close();
        }
    };


    public void doByGet(String url ,List<BasicNameValuePair>parmeget,String charset) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        url += ("?")+ URLEncodedUtils.format(parmeget,charset);
        System.out.println(url);
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse httpResponse =null;
        try {
            httpResponse = httpClient.execute(httpGet);
            int code = httpResponse.getStatusLine().getStatusCode();
            String bodydata = EntityUtils.toString(httpResponse.getEntity());
            String headall = Arrays.toString(httpResponse.getAllHeaders());
            System.out.println("请求响应码"+"【"+code+ "】");
            System.out.println("请求体"+"【"+bodydata+ "】");
            System.out.println("请求头"+"【"+headall+ "】");

        }
        finally {
            if (httpResponse !=null){
                httpResponse.close();
            }
            httpClient.close();
        }


    };



}
