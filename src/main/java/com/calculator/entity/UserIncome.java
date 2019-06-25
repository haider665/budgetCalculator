package com.calculator.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_income")
public class UserIncome {
	
	@Id
	@Column(name="income_id")
	private int income_id;
	@Column(name="income_value")
    private int income_value;
	@Column(name="description")
    private String description;
	
	@ManyToOne(fetch= FetchType.LAZY, cascade= {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}  )
	@JoinColumn(name="user_id")
	private User user;
    
	public UserIncome() {}

	public UserIncome(int income_id, int income_value, String email) {
		super();
		this.income_id = income_id;
		this.income_value = income_value;
	
	}

	public int getIncome_id() {
		return income_id;
	}

	public void setIncome_id(int income_id) {
		this.income_id = income_id;
	}

	public int getIncome_value() {
		return income_value;
	}

	public void setIncome_value(int income_value) {
		this.income_value = income_value;
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
		return "UserIncome [income_id=" + income_id + ", income_value=" + income_value +  "]";
	}
	
	
	

}
