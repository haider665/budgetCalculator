package com.calculator.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.calculator.entity.User;

@Entity
@Table(name="user_expense")
public class UserExpense {

	
	@Id
	@Column(name="expense_id")
	private int expense_id;
	@Column(name="expense_value")
    private int expense_value;
	@Column(name="description")
    private String description;
	
	@ManyToOne(fetch= FetchType.LAZY, cascade= {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}  )
	@JoinColumn(name="user_id")
	private User user;
	
	public UserExpense(int expense_id, int expense_value) {
		super();
		this.expense_id = expense_id;
		this.expense_value = expense_value;
		
	}
	
	public UserExpense() {
	}

	public int getExpense_id() {
		return expense_id;
	}

	public void setExpense_id(int expense_id) {
		this.expense_id = expense_id;
	}

	public int getExpense_value() {
		return expense_value;
	}

	public void setExpense_value(int expense_value) {
		this.expense_value = expense_value;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserExpense [expense_id=" + expense_id + ", expense_value=" + expense_value + ", description="
				+ description + ", user=" + user + "]";
	}

	
	
	
	
}
