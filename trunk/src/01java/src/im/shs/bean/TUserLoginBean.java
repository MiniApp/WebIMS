/**    
 * Class Name：	
 *			TUserLoginBean.java
 * Version：	1.1   
 * Date：	2014-1-16       
 * Copyright	
 */
package im.shs.bean;

import java.util.Date;

/**    
 *         
 * Class Name：
 *			TUserLoginBean    
 * Description：    
 *			描述
 * @Author	suhao
 * @Date	2014-1-16 下午1:11:44    
 * @Version	
 *     
 */
public class TUserLoginBean {
    private String name;

    private String accessToken;

    private Integer expiresIn;

    private Date expiresDate;

    private String refreshToken;

    private String openid;

    private String openkey;

    private String nick;

    private String state;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Date getExpiresDate() {
        return expiresDate;
    }

    public void setExpiresDate(Date expiresDate) {
        this.expiresDate = expiresDate;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOpenkey() {
        return openkey;
    }

    public void setOpenkey(String openkey) {
        this.openkey = openkey;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
