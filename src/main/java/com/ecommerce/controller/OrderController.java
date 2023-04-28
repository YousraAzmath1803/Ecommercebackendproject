package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Order;
import com.ecommerce.model.Product;
import com.ecommerce.service.OrderService;
import com.ecommerce.util.Response;

@RequestMapping("/order")
@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Response> placeOrder(@RequestBody Order order){
		System.out.println(order);
		Response response=orderService.placeOrder(order);
		if(response.getOperation() == true) {
			return new ResponseEntity<Response>(response,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<Response>(response,HttpStatus.BAD_REQUEST);
		}
		
		
	}
	@CrossOrigin
	@GetMapping("/list")
	 public ResponseEntity<List<Order>> getAllOrders() {
		
		  List<Order> result =  orderService.get();
		  
		  return new ResponseEntity<List<Order>>(result, HttpStatus.OK);
	 }
	@CrossOrigin
	@PostMapping("/orderById/{id}")
	public ResponseEntity<Order> getOrderbyId(@PathVariable("id") int id){
		    System.out.println("userid"+ id);
		Order result = orderService.getOrderByid(id);
		 return new ResponseEntity<Order>(result, HttpStatus.OK);
	}
	@CrossOrigin
	@PostMapping("/orderlist")
	 public ResponseEntity<List<Order>> getMultipleOrdersByid() {
		
		  List<Order> result =  orderService.getMultipleOrdersByid();
		  
		  return new ResponseEntity<List<Order>>(result, HttpStatus.OK);
	 }
}
