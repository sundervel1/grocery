package com.cdac.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.bean.Grocery;
import com.cdac.dao.IGroceryDao;
import com.cdac.exception.GroceryException;

@Transactional
@Service
public class GroceryServiceImpl implements IGroceryService{

	@Autowired
	IGroceryDao groceryDao;
	
	@Override
	public int addGrocery(Grocery grocery) throws GroceryException {
		//System.out.println("addGrocery : " + grocery);
		return groceryDao.addGroceryItem(grocery);
	}

	@Override
	public List<Grocery> getGroceryList() throws GroceryException {
		//System.out.println("getGroceryList");
		return groceryDao.getGroceryList();
	}

	@Override
	public List<String> getCategory() throws GroceryException {
		//System.out.println("getCategory");
		return groceryDao.getCategory();		
	}

}
