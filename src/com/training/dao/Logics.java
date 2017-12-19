package com.training.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.training.entity.Customer;
import com.training.entity.Transaction;
import com.training.entity.User;

@Repository
public class Logics {

	@Autowired
	private HibernateTemplate template;
	
	@Autowired
	private Customer customer;
	
	@Autowired
	private Transaction tx;
	
	@Autowired
	private User user;
	
	public User login(String userName,String passWord){
		//long key=0;
		System.out.println("login");
		System.out.println(userName);
		System.out.println(passWord);
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class); 
		criteria.add(Restrictions.eq("userName", userName)); 
		criteria.add(Restrictions.eq("passWord", passWord));
		List<User> users=(List<User>) template.findByCriteria(criteria);
		User obj=null;
		for(User u:users){
			 obj=u;
		}
		//System.out.println(user.toString());
		return obj;
		
	}
	
	public int withdraw(){
		
		int status=0;
		return status;
	}
	
	
}
