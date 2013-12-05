package im.shs.dao;

import im.shs.model.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(User user) {
		getSession().save(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findByUsername(String username) {
		 return
		 (List<User>)getSession().get("from User u where u.name = ?",username);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> listUser(){
		return getSession().createQuery("from User u").list();
	}
}
