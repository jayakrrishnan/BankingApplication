package com.training.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.staticmock.MockStaticEntityMethods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.training.dao.CustomerImpl;
import com.training.dao.Logics;
import com.training.dao.TransactionImpl;
import com.training.entity.Customer;
import com.training.entity.Transaction;
import com.training.entity.User;

@Controller
public class WelcomeController {

	@Autowired
	private ModelAndView mdlView;

	@Autowired
	private TransactionImpl tDao;

	@Autowired
	private CustomerImpl cDao;

	@Autowired
	private Logics lDao;

	@Autowired
	private Transaction tx;

	@Autowired
	private Customer customer;

	@Autowired
	private User user;

	static long cId = 100000;

	static long tId = 200000;

	@RequestMapping("/")
	public ModelAndView init() {

		
		mdlView.addObject("command1", customer);
		mdlView.addObject("command2", customer);
		mdlView.setViewName("index");
		return mdlView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView onLoginSubmit(@ModelAttribute("fromJsp") Customer obj,
			@RequestParam("userName") String userName, @RequestParam("passWord") String passWord, Model model,
			HttpSession session) {

		
		User user = lDao.login(userName, passWord);

		mdlView.setViewName("index");
		
		if (user != null) {

			Customer cust = cDao.findById(user.getUserId());

			session.setAttribute("customerUser", cust);
			session.setAttribute("user", user);

			mdlView.addObject("obj", user);
			mdlView.setViewName("welcome");

		}
		else {
			mdlView.addObject("error", "Incorrect credentials");
			mdlView.setViewName("index");
		}

		return mdlView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView onRegisterSubmit(@ModelAttribute("command2") Customer obj,
			@RequestParam("userName") String userName, @RequestParam("passWord") String passWord, Model model) {

		Customer newCust = new Customer(userName, passWord, obj.getCustomerName(), obj.getAddressLine1(),
				obj.getAddressLine2(), obj.getCity(), obj.getZipCode(), obj.getMobileNumber(), obj.getEmail(),
				obj.getAccountNumber(), obj.getAccountType(), obj.getBranchName(), obj.getBalance());
		System.out.println(newCust.toString());
		long key = cDao.add(newCust);
		if(key>0) {
			mdlView.addObject("success", "Success");
		}
		else {
			mdlView.addObject("success", "Already Exists");
		}
		mdlView.setViewName("index");

		return mdlView;
	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public ModelAndView onWithdrawGet(HttpSession session) {
		
		User obj = (User) session.getAttribute("user");
		
		Customer cust = cDao.findById(obj.getUserId());
		session.setAttribute("customerUser", cust);
		
		mdlView.setViewName("withdraw");
		return mdlView;

	}

	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public ModelAndView onWithdraw(@RequestParam("amount") long amount, @RequestParam("passWord") String passWord,
			Model model, HttpSession session) {

		Customer obj = (Customer) session.getAttribute("customerUser");
		User u = (User) session.getAttribute("user");

		if (u.getPassWord().equals(passWord)) {

			Transaction t = new Transaction(amount, obj.getAccountNumber(), obj.getAccountNumber(), new Date());
			long key = tDao.add(t);
			cDao.balanceUpdate(obj, amount);
			mdlView.addObject("obj", obj);
			mdlView.addObject("msg", "Successfully withdrawed");
			mdlView.setViewName("welcome");
		}
		else {
			mdlView.setViewName("withdraw");
			mdlView.addObject("msg", "Wrong Password");
		}

		return mdlView;
	}

	@RequestMapping(value = "/transfer", method = RequestMethod.GET)
	public ModelAndView ontransferGet() {
		mdlView.setViewName("transfer");
		return mdlView;

	}

	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	public ModelAndView onTransfer(@RequestParam("amount") long amount, @RequestParam("passWord") String passWord,
			@RequestParam("toAccount") long toAccount, Model model, HttpSession session) {

		Customer obj = (Customer) session.getAttribute("customerUser");
		User u = (User) session.getAttribute("user");

		if (u.getPassWord().equals(passWord)) {

			Transaction t = new Transaction(amount, obj.getAccountNumber(), toAccount, new Date());
			long key = tDao.add(t);
			cDao.balanceUpdate(obj, amount);
			mdlView.addObject("msg", "Successfully transfered");

			mdlView.setViewName("welcome");
		}
		else {
			mdlView.setViewName("transfer");
			mdlView.addObject("msg", "Wrong Password");
		}

		return mdlView;
	}

	@RequestMapping(value = "/statement", method = RequestMethod.GET)
	public ModelAndView onStatement(HttpSession session) {
		Customer obj = (Customer) session.getAttribute("customerUser");
		List<Transaction> txs = tDao.findAll(obj.getAccountNumber());
		System.out.println(txs);
		mdlView.addObject("txs", txs);
		mdlView.setViewName("miniStatement");

		return mdlView;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView onHome(HttpSession session) {

		Customer obj = (Customer) session.getAttribute("customerUser");
		mdlView.addObject("obj", obj);
		mdlView.setViewName("welcome");
		mdlView.addObject("msg", "");
		return mdlView;

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView onLogout(HttpSession session) {

		session.invalidate();
		mdlView.setViewName("index");

		return mdlView;

	}

}