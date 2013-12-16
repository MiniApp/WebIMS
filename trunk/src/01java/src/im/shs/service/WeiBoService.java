package im.shs.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public interface WeiBoService {
    public String tencentWeiboLoginInit();

    public Map<String, Object> tencentWeiboLogin(String code_temp) throws UnsupportedEncodingException;
}
