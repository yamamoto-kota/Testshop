package com.basic.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basic.entity.SendData;
import com.basic.entity.SendItem;
import com.basic.entity.CartData;
import com.basic.form.SendForm;
import com.basic.service.ShopService;




@RestController
@CrossOrigin
public class ShopController {

	
	@Autowired
	private ShopService shopService;
	
	//一覧表示
//	@GetMapping("/testview")
//	public SendData index(){
//		SendData sendData = new SendData();
//		sendData = shopService.getAll();
//		SendItem goods = new SendItem();
//		System.out.println(sendData.getAllGoods().get(0).getName());
//		return sendData;
//	}
	@GetMapping("/testview")
	public List<SendItem> index(){
		List<SendItem> allgoods = new ArrayList<>();
		allgoods = shopService.getAll().getAllGoods();
		return allgoods;
	}
	@GetMapping("/testview2")
	public List<SendItem> index2(){
		List<SendItem> cartgoods = new ArrayList<>();
		cartgoods = shopService.getAll().getCartGoods();
		return cartgoods;
	}
	

	//商品追加
	@PostMapping("/insert")
	public void addItem(@RequestBody CartData sendItem) {
		System.out.println(sendItem.getName());
		shopService.sendAddItem(sendItem);
	}
	
	//商品削除
	@PostMapping("/delete")
	public void delItem(@RequestBody CartData sendItem) {
		shopService.sendDelItem(sendItem);
	}
	
	//注文確定
	@PostMapping("orderconfirm")
		public void orderConfirm(@RequestBody SendForm sendForm) {
			shopService.sendOrderConfirm(sendForm);
			System.out.println(sendForm.getDate());
		}
}

