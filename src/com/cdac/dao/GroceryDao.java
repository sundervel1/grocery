package com.cdac.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.cdac.bean.Grocery;
import com.cdac.exception.GroceryException;

@Transactional
@Repository
public class GroceryDao implements IGroceryDao {

	@PersistenceContext
	EntityManager entityManager;
	Logger logger = Logger.getLogger(GroceryDao.class);
	
	@Override
	public int addGroceryItem(Grocery grocery) throws GroceryException {
		//System.out.println("DAO : "+grocery);
		try{
		   entityManager.persist(grocery);
		   logger.info("Saved grocery : " + grocery.getName());
		}
		catch(Exception e){
			//e.printStackTrace();
			logger.error("Error in inserting data "+e);
			throw new GroceryException("Error in inserting data ");
		}
		return 1;
	}

	@Override
	public List<Grocery> getGroceryList() throws GroceryException {
		String sql = "SELECT list from Grocery list";
		try{
		TypedQuery<Grocery> query = entityManager.createQuery(sql, Grocery.class);
		   logger.info("Fetching Grocery List  ");
		return query.getResultList();
		}
		catch(Exception e){
			//e.printStackTrace();
			logger.error("Error in fetching data "+e);
			throw new GroceryException("Error in fetching data ");
		}
	}

	@Override
	public List<String> getCategory() throws GroceryException {
		//System.out.println("getCategory");
		TypedQuery<String> query=null;
		try{
		String sql = "SELECT cat.category from Category cat";
		query = entityManager.createQuery(sql, String.class);
		   logger.info("Fetching categories " );
			return query.getResultList();
		}
		catch(Exception e){
			//e.printStackTrace();
			logger.error("Error in loading category "+e);
			throw new GroceryException("Error in loading category ");
		}
       /* List<String> aList = new ArrayList<>();
		aList.add("Pulses");
		aList.add("Cooking Oil");
		aList.add("Vegetables");
		aList.add("Fruits");
		aList.add("Condiments");
		aList.add("Cereals");		
		return aList;*/
	}

}
