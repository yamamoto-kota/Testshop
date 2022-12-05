package com.basic.form;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "UserForm")
public class SendForm {
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}





	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}



//	@Id
//	//@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "ID")
//	private int id;
	
	@Column(name = "username")
	String userName;
	
	@Column(name = "address")
	String address;
	
	@Column(name = "totalprice")
	Integer totalPrice;
	
	@Column(name = "purchasedate")
	String date;
}
