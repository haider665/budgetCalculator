package com.calculator.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
@Table(name="user")
public class User {

	@Id
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	private List<UserExpense> user_expense; 
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH })
	@Fetch(FetchMode.SELECT)
	private List<UserIncome> user_income;
	
	
	public User() {
	}
	
	public User(String email, String password) {
		
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<UserExpense> getUser_expense() {
		return user_expense;
	}

	public void setUser_expense(List<UserExpense> user_expense) {
		this.user_expense = user_expense;
	}

	public List<UserIncome> getUser_income() {
		return user_income;
	}

	public void setUser_income(List<UserIncome> user_income) {
		this.user_income = user_income;
	}

	public void addExpense(UserExpense userEx) {
		if(user_expense ==null) {
			user_expense = new ArrayList();
		}
		user_expense.add(userEx);
		userEx.setUser(this);
	}
	
	public void addIncome(UserIncome userIn) {
		if(user_income ==null) {
			user_income = new ArrayList();
		}
		user_income.add(userIn);
		userIn.setUser(this);
	}
	
	public double totalIncome() {
		double sum=0;
		for(int i=0; i<user_income.size(); i++) {
			sum=sum+ user_income.get(i).getIncome_value();
		}
		return sum;
	}
	
	public double totalExpense() {
		double sum=0;
		for(int i=0; i<user_expense.size(); i++) {
			sum=sum+ user_expense.get(i).getExpense_value();
		}
		return sum;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + "]";
	}
	
	
	

}
