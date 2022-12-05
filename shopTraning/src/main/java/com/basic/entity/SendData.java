package com.basic.entity;

import java.util.List;


public class SendData {

	private List<SendItem> allGoods;
	private List<SendItem> cartGoods;
	
	public List<SendItem> getAllGoods() {
		return allGoods;
	}
	public void setAllGoods(List<SendItem> allGoods) {
		this.allGoods = allGoods;
	}
	public List<SendItem> getCartGoods() {
		return cartGoods;
	}
	public void setCartGoods(List<SendItem> cartGoods) {
		this.cartGoods = cartGoods;
	}
}