package com.basic.Dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import com.basic.entity.SendItem;
import com.basic.form.SendForm;
import com.basic.entity.CartData;

@Dao
@ConfigAutowireable
public interface ShopDao {

	@Select
	List<SendItem> selectAll();

	@Select
	List<SendItem> selectCart();
	
	@Insert
	int insertItem(CartData item);
	
	@Update
	int updateItem(CartData sendItem);

	@Delete
	int deleteItem(CartData sendItem);

	@Insert
	int insertUserForm(SendForm userForm);

	@Select
	List<SendForm> selectUser();
}
