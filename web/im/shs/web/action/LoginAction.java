/**    
 * Class Name：	
 *			LoginAction.java
 * Version：	1.1   
 * Date：	2013-7-30       
 * Copyright	
 */
package im.shs.web.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

/**    
 *         
 * Class Name：
 *			LoginAction    
 * Description：    
 *			描述
 * Author：	Administrator    
 * Date：	2013-7-30 下午1:40:51    
 * @version	
 *     
 */
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	private static final Log logger = LogFactory.getLog(LoginAction.class);
	private String userName;
	private String passWord;

	public String getUserName() {
		return userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String execute() throws Exception {
		if (userName.equals("1") && passWord.equals("1")) {
			logger.info("Hello debug");
			return ActionSupport.SUCCESS;
		} else {
			return "";
		}
	}
}
