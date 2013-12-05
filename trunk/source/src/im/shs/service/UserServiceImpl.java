package im.shs.service;

import im.shs.base.AbstractService;
import im.shs.base.persist.PaginationSupport;
import im.shs.bean.UserBean;
import im.shs.bean.UserCriteria;
import im.shs.model.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends AbstractService implements UserService {
    @SuppressWarnings("unused")
    private final Log logger = LogFactory.getLog(UserServiceImpl.class);
	@SuppressWarnings("unchecked")
	@Override
	public PaginationSupport<UserBean> getUserList(UserCriteria criteria) {
		PaginationSupport<UserBean> list = (PaginationSupport<UserBean>) this.getPersist().findPaginatedBySqlMap("user.getUserList", criteria, criteria.getStartIndex(), criteria.getPageSize());

		return list;
	}

	@Override
	public void addUser(UserBean bean) {
	    User po = new User();
	    po.setName(bean.getName());
	    po.setAge(bean.getAge());
	    
	    this.getPersist().persist(po);
	}
}
