package com.calculator.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.calculator.entity.User;

public class UserDaoImplementation implements UserDao {
	
	private SessionFactory factory;
	@Override
	public void addUser(User user) {
		
		openFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		
		closeFactory();
	}
	@Override
	public User getUser(String email,String password) {
		openFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		String hql="from User u where u.email= :user_email and u.password = :user_password"; //
		Query query = session.createQuery(hql);
		query.setParameter("user_email",email);
		query.setParameter("user_password",password);
		List<User> user= query.list();
		session.getTransaction().commit();
		closeFactory();
		if(user.size()==0) {
			return null;
		} else
		return user.get(0);
	}
	@Override
	public User getUserById(String id) {
		openFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		User user=(User) session.get(User.class, id);
		session.getTransaction().commit();
		
		closeFactory();	
		return user;
	}
	
	public void openFactory() {
		factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
	}
	public void closeFactory() {
		factory.close();
	}
	

}
