package im.shs.service;

import im.shs.base.persist.PaginationSupport;
import im.shs.bean.UserBean;
import im.shs.bean.UserCriteria;

public interface UserService{
	public PaginationSupport<UserBean> getUserList(UserCriteria criteria);
	public void addUser(UserBean bean);
}
