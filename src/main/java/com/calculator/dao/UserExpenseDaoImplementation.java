package com.calculator.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.calculator.entity.UserExpense;

public class UserExpenseDaoImplementation implements UserExpenseDao {

	private SessionFactory factory;
	@Override
	public void add(UserExpense useEx) {
		openFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(useEx);
		session.getTransaction().commit();
		
		closeFactory();
	}
	
	public void openFactory() {
		factory = (SessionFactory) new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserExpense.class).buildSessionFactory();
	}
	public void closeFactory() {
		factory.close();
	}

}
