package com.cdac.dao;

import java.util.List;

import com.cdac.bean.Grocery;
import com.cdac.exception.GroceryException;

public interface IGroceryDao {


	List<String> getCategory() throws GroceryException;

	int addGroceryItem(Grocery grocery) throws GroceryException;

	List<Grocery> getGroceryList() throws GroceryException;

}
