package im.shs.service;

import im.shs.base.AbstractService;
import im.shs.base.util.CommonUtils;
import im.shs.bean.UserBean;
import im.shs.po.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service("test")
public class TestServiceImpl extends AbstractService implements TestService{

	@SuppressWarnings("rawtypes")
	@Override
	public void getList() {
		List list = this.getPersist().findList("user.getListTest", "");
		if (1==1){
			
		}
	}

	@Override
	public Integer addUser() {
		UserBean user = new UserBean();
		String ages = CommonUtils.getRandStr(3, true);
		Integer age = Integer.parseInt(ages);
		String name = CommonUtils.getRandStr(4, false);
		user.setAge(age);
		user.setName(name);
		this.getPersist().add("user.add", user);
		return 1;
	}

	/**    
	 * Method：	testBatchMerge
	 *
	 * Description：	
	 *			描述
	 * @param  	name
	 *			参数 
	 * @return	String DOM对象    
	 * @since   
	 */
	@Override
	public void testBatchMerge() {
		List<User> list = new ArrayList<User>();
		for (int i = 1; i <= 10; i++) {
			User user = this.getPersist().find(User.class, i);
			list.add(user);
		}
		
		for (int i = 0; i < list.size(); i++) {
			User user = list.get(i);
			user.setName("Suhao"+i);
		}
		this.getPersist().batchMerge(list);
	} 

}
