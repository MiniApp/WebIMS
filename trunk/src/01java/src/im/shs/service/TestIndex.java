package im.shs.service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.Resource;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;

//@Component
/**    
 *         
 * Class Name：
 *			TestIndex    
 * Description：    
 *			描述
 * @Author	suhao
 * @Date	2013-12-20 上午11:21:10    
 * @Version	
 *     
 */
public class TestIndex {
    @Resource(name="tctService")
    private TctService tc;
    static int i = 0;
    
   // @Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次 
    public void call(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateStr = sdf.format(date);
        //String url = ws.tencentWeiboLoginInit();
        NameValuePair[] params = new NameValuePair[]{};
        //  String CallResult = this.doHttpClient(url, params);
        //System.out.println(CallResult);
        //ws.tencentWeiboLogin("87b261e5f6b18077bc782e1083240d8f");
        //tc.batchAddStatus();
        
        System.out.println("excute " + i++ + " time: " + dateStr);
    }
    
    /**
     * 调用httpClient
     * @param url 要访问的地址
     * @param params 要携带的参数
     * @return
     */
    private String doHttpClient(String url, NameValuePair[] params) {
        PostMethod post = new PostMethod(url);

        post.setRequestBody(params);

        HttpClient client = new HttpClient();

        String str_result = ""; // 页面返回结果

        try {
            client.executeMethod(post); // 执行post方法
            str_result = post.getResponseBodyAsString();
            return str_result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            post.releaseConnection();
        }

        return "";

    }
}
