package com.basic.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

@Entity
@Table(name = "AllGoods")
public class SendItem {

	@Id
	@Column(name = "ID")
	Integer id;
	
	@Column(name = "quantity")
	Integer quantity;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "genre")
	String genre;
	
	@Column(name = "price")
	Integer price;
	
	@Column(name = "IMG")
	String IMG;
	
	@Column(name = "purchaseflag")
	Integer purchaseflag;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getIMG() {
		return IMG;
	}

	public void setIMG(String iMG) {
		IMG = iMG;
	}

	public Integer getPurchaseflag() {
		return purchaseflag;
	}

	public void setPurchaseflag(Integer purchaseflag) {
		this.purchaseflag = purchaseflag;
	}
}
