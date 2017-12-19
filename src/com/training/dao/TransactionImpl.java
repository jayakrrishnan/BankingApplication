package com.training.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.training.entity.Customer;
import com.training.entity.Transaction;
import com.training.ifaces.GenericDao;


@Repository
public class TransactionImpl implements GenericDao<Transaction> {
	

	@Autowired
	private HibernateTemplate template;
	
	@Autowired
	private Transaction tx;
	
	public TransactionImpl() {
		super();
		
	}

	@Override
	public long add(Transaction object) {

		long key = (long) template.save(object);
		
		return key;
	}

	@Override
	public long update(long key, String accountType,  String passWord) {
		
			return 0;
	}

	@Override
	public long delete(long key) {

		return 0;
	}

	@Override
	public Transaction findById(long key) {
		
		return null;
	}

	@Override
	public List<Transaction> findAll() {

		
		return null;
	}
	public List<Transaction> findAll(long key){
		DetachedCriteria criteria = DetachedCriteria.forClass(Transaction.class); 
		criteria.add(Restrictions.eq("fromAccount", key)); 
		List<Transaction> txs=(List<Transaction>) template.findByCriteria(criteria);
		return txs;
	}

}
