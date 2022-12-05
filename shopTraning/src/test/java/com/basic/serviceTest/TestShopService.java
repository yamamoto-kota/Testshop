package com.basic.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsEmptyIterable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.basic.Dao.ShopDao;
import com.basic.entity.CartData;
import com.basic.entity.SendItem;
import com.basic.form.SendForm;
import com.basic.service.ShopService;

import static org.hamcrest.MatcherAssert.*;


@SpringBootTest
public class TestShopService {

	String A = "a";
	@Autowired
	ShopService shopService;
	@Autowired
	ShopDao shopDao;
	List<SendItem> allGoods= new ArrayList<>();
	List<SendItem> cartGoods= new ArrayList<>();
	
	
	@Test
	@DisplayName("全ての商品の一覧、カート内の商品の一覧が返ってくる")
	public void getAllTest() {
		//全商品の返り値の一番目
		allGoods = shopService.getAll().getAllGoods();
		//allGoods[0]の期待値
		SendItem allans = new SendItem();
		allans.setName("bread");
		allans.setId(1);
		allans.setPrice(100);
		allans.setQuantity(0);
		allans.setGenre("eat");
		List<SendItem> allGoods_ans = new ArrayList();
		allGoods_ans.add(0, allans);
		
		//カート内の全商品の返り値
        cartGoods = shopService.getAll().getCartGoods();
      //allGoods[0]の期待値
      		SendItem cartans = new SendItem();
      		cartans.setName("bread");
      		cartans.setId(1);
      		cartans.setPrice(100);
      		cartans.setQuantity(1);
      		cartans.setGenre("eat");
		List<SendItem> cartGoods_ans = new ArrayList();
		cartGoods_ans.add(0, cartans); 
		
	assertThat(allGoods.get(0).getName(), is(allans.getName()));
	assertThat(allGoods.get(0).getId(), is(allans.getId()));
	assertThat(allGoods.get(0).getQuantity(), is(allans.getQuantity()));
	assertThat(allGoods.get(0).getPrice(), is(allans.getPrice()));
	assertThat(allGoods.get(0).getGenre(), is(allans.getGenre()));
	
	assertThat(cartGoods.get(0).getName(), is(cartans.getName()));
	assertThat(cartGoods.get(0).getId(), is(cartans.getId()));
	assertThat(cartGoods.get(0).getQuantity(), is(cartans.getQuantity()));
	assertThat(cartGoods.get(0).getPrice(), is(cartans.getPrice()));
	assertThat(cartGoods.get(0).getGenre(), is(cartans.getGenre()));
	}
	
//	@Test
//	@DisplayName("商品が存在しないときemptyが返ってくる")
//	public void getAll_nullTest() {
//		allGoods = shopService.getAll().getAllGoods();
//		cartGoods = shopService.getAll().getCartGoods();
//		
//		assertThat(allGoods.get(0).getName().isEmpty() );
//		assertThat(cartGoods.get(0).getName().isEmpty() );
//	}
	
	@Test
	@DisplayName("カートに新しく商品を追加する")
	public void addItemTest1() {
		CartData bicycle = new CartData();
		bicycle.setName("bicycle");
		bicycle.setId(3);
		bicycle.setPrice(300);
		bicycle.setQuantity(1);
		bicycle.setGenre("other");
		shopService.sendAddItem(bicycle);
		cartGoods = shopService.getAll().getCartGoods();
		
		assertThat(cartGoods.get(3).getName(), is(bicycle.getName()));
		assertThat(cartGoods.get(3).getId(), is(bicycle.getId()));
		assertThat(cartGoods.get(3).getQuantity(), is(bicycle.getQuantity()));
		assertThat(cartGoods.get(3).getPrice(), is(bicycle.getPrice()));
		assertThat(cartGoods.get(3).getGenre(), is(bicycle.getGenre()));
	}
	
	@Test
	@DisplayName("カート内の商品の数を増やす")
	public void addItemTest() {
		CartData apple = new CartData();
		apple.setName("apple");
		apple.setId(2);
		apple.setPrice(200);
		apple.setQuantity(2);
		apple.setGenre("eat");
		shopService.sendAddItem(apple);
		cartGoods = shopService.getAll().getCartGoods();

		
		assertThat(cartGoods.get(1).getName(), is(apple.getName()));
		assertThat(cartGoods.get(1).getId(), is(apple.getId()));
		assertThat(cartGoods.get(1).getQuantity(), is(apple.getQuantity()));
		assertThat(cartGoods.get(1).getPrice(), is(apple.getPrice()));
		assertThat(cartGoods.get(1).getGenre(), is(apple.getGenre()));
	}

	@Test
	@DisplayName("カート内の商品の数を減らす")
	public void delItemTest() {
		CartData apple = new CartData();
		apple.setName("apple");
		apple.setId(2);
		apple.setPrice(200);
		apple.setQuantity(2);
		apple.setGenre("eat");
		shopService.sendDelItem(apple);
		cartGoods = shopService.getAll().getCartGoods();

		
		assertThat(cartGoods.get(1).getName(), is(apple.getName()));
		assertThat(cartGoods.get(1).getId(), is(apple.getId()));
		assertThat(cartGoods.get(1).getQuantity(), is(1));
		assertThat(cartGoods.get(1).getPrice(), is(apple.getPrice()));
		assertThat(cartGoods.get(1).getGenre(), is(apple.getGenre()));
	}
	
//	@Test
//	@DisplayName("カート内の商品を削除する")
//	public void delItemTest2() {
//		List<SendItem> delList = shopService.getAll().getCartGoods();
//		CartData PC = new CartData();
//		PC.setName("PC");
//		PC.setId(4);
//		PC.setPrice(1000);
//		PC.setQuantity(1);
//		PC.setGenre("other");
//		shopService.sendDelItem(PC);
//		cartGoods = shopService.getAll().getCartGoods();
//
//		assertThat(delList.get(2).getName().isEmpty());
//		assertThat(delList.get(2).getId(),is(4));
//		assertThat(delList.get(2).getQuantity(),is(0));
//		assertThat(delList.get(2).getPrice(),is(0));
//		assertThat(delList.get(2).getGenre().isEmpty());
//	}
	
	@Test
	@DisplayName("購入者情報の更新")
	public void delCinfirmTest() {
		SendForm formTest = new SendForm();
		formTest.setAddress("testAddress");
		formTest.setUserName("KOTA");
		shopService.sendOrderConfirm(formTest);
		
		List<SendForm> sendForm = new ArrayList<>();
		sendForm = shopService.sendSendForm();
		
		assertThat(sendForm.get(0).getUserName(),is(formTest.getUserName()));
		assertThat(sendForm.get(0).getAddress(),is(formTest.getAddress()));
	}
}
