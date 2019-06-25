package com.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.calculator.dao.UserDao;
import com.calculator.dao.UserDaoImplementation;
import com.calculator.dao.UserExpenseDaoImplementation;
import com.calculator.dao.UserIncomeDaoImplementation;
import com.calculator.entity.User;
import com.calculator.entity.UserExpense;
import com.calculator.entity.UserIncome;

@Controller
public class HomeController {
	
	@Autowired
	UserDaoImplementation userDao;
	@Autowired
	UserIncomeDaoImplementation userInDao;
	@Autowired
	UserExpenseDaoImplementation userExDao;
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("haider", new User() );
		return "front-page";
	}
	
	@RequestMapping("/asd")
	public String asd(@RequestParam ("a") String name) {
		System.out.println(name);
		return "index";
	}
	
	@PostMapping("/signUp")
	public String signUp(@ModelAttribute ("haider") User user) {
		try{
			userDao.addUser(user);
		} catch(Exception e) {
			return "fail-signUp";
		}
		System.out.println(user);
		return "redirect:/";
	}
	
	@RequestMapping("/logIn")
	public String logIn(@ModelAttribute ("haider") User user, Model model) {
		User us=userDao.getUser(user.getEmail(), user.getPassword());
		System.out.println(us);
		if(us==null) {
			return "fail-signUp";
		}
		model.addAttribute("user", us);
		model.addAttribute("income",us.totalIncome());
		model.addAttribute("expense", us.totalExpense());
		model.addAttribute("budget", us.totalIncome()- us.totalExpense());
		
		return "home";
	}
	@RequestMapping("/logOut")
	public String logOut(Model model, SessionStatus status ) {
		status.setComplete();
		model.addAttribute("haider", new User());
		return "front-page";
	}
	
	@PostMapping("/processForm")
	public String processForm(@RequestParam ("type") String type,@RequestParam ("des") String des,
			@RequestParam ("val") int val, @RequestParam ("userEmail") String email, Model model) {
		
		User user = userDao.getUserById(email);
		storeIncExp(type, des, val, user);
		
		model.addAttribute("user", user);
		model.addAttribute("income",user.totalIncome());
		model.addAttribute("expense", user.totalExpense());
		model.addAttribute("budget", user.totalIncome()- user.totalExpense());
		model.addAttribute("incomeList", 12);
		model.addAttribute("expenseList", user.getUser_expense());
		return "home";
	}
	
	
	public void storeIncExp(String type,String des, int val, User user) {
		if(type.equals("exp")) {
			UserExpense useEx= new UserExpense();
			useEx.setExpense_value(val);
			useEx.setDescription(des);
			System.out.println(useEx);
			user.addExpense(useEx);
			userExDao.add(useEx);
		}
		else if (type.equals("inc")) {
			UserIncome userIn = new UserIncome();
			userIn.setDescription(des);
			userIn.setIncome_value(val);
			user.addIncome(userIn);
			userInDao.add(userIn);
		}
	}
	
}







