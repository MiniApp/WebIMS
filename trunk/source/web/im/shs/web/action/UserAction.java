package im.shs.web.action;

import im.shs.bean.UserBean;
import im.shs.service.TestService;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;

/**    
 *         
 * Class Name：
 *			UserAction    
 * Description：    
 *			描述
 * @Author：	MiniApp    
 * @Date：	2013-8-4 上午10:46:24    
 * @version	
 *     
 */
public class UserAction extends ActionSupport {
	private String name;
	private String age;
	private UserBean user;
	@Resource(name = "test")
	private TestService test;

	public String queryUser() {
		test.getList();
		return SUCCESS;
	}

	public String addUser() {
		// String name = user.getName();
		test.addUser();
		return "userAdd";
	}
	
	public String batchMerge() {
		test.testBatchMerge();
		return "batchMerge";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
}
