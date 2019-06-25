package com.calculator.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.calculator.entity.UserIncome;

public class UserIncomeDaoImplementation implements UserIncomeDao {

	private SessionFactory factory;
	@Override
	public void add(UserIncome userIn) {
		openFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(userIn);
		session.getTransaction().commit();
		
		closeFactory();
	}
	
	public void openFactory() {
		factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserIncome.class).buildSessionFactory();
	}
	public void closeFactory() {
		factory.close();
	}

}
