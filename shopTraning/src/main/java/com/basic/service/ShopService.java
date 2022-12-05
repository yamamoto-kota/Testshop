package com.basic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.Dao.ShopDao;
import com.basic.entity.SendData;
import com.basic.entity.SendItem;
import com.basic.entity.CartData;
import com.basic.form.SendForm;

@Service
public class ShopService {
	
	@Autowired
	ShopDao shopDao;
	
	public SendData getAll() {
		SendData sendData = new SendData();
		List<SendItem> allGoods = new ArrayList<SendItem>();
		List<SendItem> cartGoods = new ArrayList<SendItem>();
		allGoods = shopDao.selectAll();
		cartGoods = shopDao.selectCart();
		
		sendData.setAllGoods(allGoods);
		sendData.setCartGoods(cartGoods);
		return sendData;
	}
	

	public void sendAddItem(CartData sendItem) {
		if(sendItem.getQuantity()==1) {
			shopDao.insertItem(sendItem);
			}else if(sendItem.getQuantity() >= 2) {
				shopDao.updateItem(sendItem);
			}
	}

	public void sendDelItem(CartData sendItem) {
		if(sendItem.getQuantity() == 1) {
		shopDao.deleteItem(sendItem);
		}else if(sendItem.getQuantity() >= 2) {
			System.out.println(sendItem.getQuantity());
			sendItem.setQuantity(sendItem.getQuantity()-1);
			System.out.println(sendItem.getQuantity());
			shopDao.updateItem(sendItem);
		}
	}

	public void sendOrderConfirm(SendForm userForm) {
		shopDao.insertUserForm(userForm);
	}
	
	public List<SendForm> sendSendForm(){
		List<SendForm> userList = shopDao.selectUser();
		return userList;
	}

}
