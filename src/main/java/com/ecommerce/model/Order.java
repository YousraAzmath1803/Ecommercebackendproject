package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Order {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
@Column
private int id;
@Column
private int userid;
@Column
private int  productid;


@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinColumn(name = "User_id", referencedColumnName = "id")
private User user;


@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "productid", referencedColumnName = "id")
private List<Product> product =new ArrayList<Product>();

       

public int getId() {
return id;
}


public void setId(int id) {
this.id = id;
}


public int getUserid() {
return userid;
}


public void setUserid(int userid) {
this.userid = userid;
}


public int getProductid() {
return productid;
}


public void setProductid(int productid) {
this.productid = productid;
}


public List<Product> getProduct() {
return product;
}


public void setProduct(List<Product> product) {
this.product = product;
}


@Override
public String toString() {
return "Order [id=" + id + ", userid=" + userid + ","
+ " productid=" + productid + ","
+ " product=" + product + "]";
}
}
