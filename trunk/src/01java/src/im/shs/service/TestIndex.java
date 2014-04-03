package im.shs.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

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
    @Resource(name="tctWeiBoService")
    private TencentWeiBoService tc;
    static int i = 0;
    
   // @Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次 
    public void call(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateStr = sdf.format(date);
        tc.batchAddStatus();
        
        System.out.println("excute " + i++ + " time: " + dateStr);
    }
}
