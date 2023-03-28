package com.ecommerce.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Order;
import com.ecommerce.model.Product;
import com.ecommerce.util.Response;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	EntityManager entityManager;

	@Override
	public Response placeOrder(Order order) {
		Response response=new Response();
		Session session=entityManager.unwrap(Session.class);
		int i=(int) session.save(order);
		if(i!=0) {
			response.setMessage("order placed successfullly");
			response.setOperation(true);
			response.setStatusCode(200);
			return response;
		}
		else {
			response.setMessage("order was not placed");
			response.setOperation(false);
			response.setStatusCode(500);
			return response;
		}
		
		
		
		
	}

	@Override
	public List<Order> get() {
		Session session = entityManager.unwrap(Session.class);
		List<Order> list = session.createQuery("from Order").list();
		return list;
		
		
	}
}
