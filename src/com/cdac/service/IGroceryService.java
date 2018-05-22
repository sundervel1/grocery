package com.cdac.service;

import java.util.List;

import com.cdac.bean.Grocery;
import com.cdac.exception.GroceryException;

public interface IGroceryService {

	List<String> getCategory() throws GroceryException;

	List<Grocery> getGroceryList() throws GroceryException;

	int addGrocery(Grocery grocery) throws GroceryException;

}
