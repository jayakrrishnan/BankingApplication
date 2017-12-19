package com.training.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.training.entity.Customer;
import com.training.ifaces.GenericDao;

@Repository
public class CustomerImpl implements GenericDao<Customer> {

	

	@Autowired
	private HibernateTemplate template;
	
	@Autowired
	private Customer customer;
	
	
	@Override
	public long add(Customer t) {
		long key=0;
		key=(long)template.save(t) ;
		return key;
	}

	@Override
	public long update(long key, String accountType, String passWord) {
		customer=(Customer) template.get(Customer.class,key);
		long status=0;
		if(customer==null){
			status=0;
		}
		else{
			customer.setAccountType(accountType);
			customer.setPassWord(passWord);
			template.saveOrUpdate(customer);
			status=1;
		}
		
		return status;
	}

	@Override
	public long delete(long key) {
		customer=(Customer) template.get(Customer.class,key);
		long status=0;
		if(customer==null){
			status=0;
		}
		else{
			template.delete(customer);
			status=1;
		}
		
		return status;
	}

	@Override
	public Customer findById(long key) {
		customer=(Customer) template.get(Customer.class,key);
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer>customers=template.loadAll(Customer.class);
		return customers;
		
	}

	public int balanceUpdate(Customer c,double amount){
		
			c.setBalance(c.getBalance()-amount);
			template.saveOrUpdate(c);
		
		
		return 0;
		
	}
}
