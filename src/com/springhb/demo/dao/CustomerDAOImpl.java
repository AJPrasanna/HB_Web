package com.springhb.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springhb.demo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	//@Transactional
	public List<Customer> getCustomers() {
		//get current hibernate session
		Session session=sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> query= session.createQuery("from Customer",Customer.class);
		
		//execute query
		List<Customer> customers=query.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Customer customer= session.get(Customer.class,id);
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query query= session.createQuery("delete from Customer where id=: param");
		query.setParameter("param", id);
		query.executeUpdate();
		
	}

}
