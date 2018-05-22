package com.cdac.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cdac.bean.Grocery;
import com.cdac.exception.GroceryException;
import com.cdac.service.IGroceryService;

@Controller
public class GroceryController {
	@Autowired
	IGroceryService groceryService;

	List<String> catList = null;
	List<Grocery> glist;

	@RequestMapping(value = "/addGrocery.obj")
	public String redirectToAddGrocery(Model model) throws GroceryException {
		Grocery grocery = new Grocery();
		catList = groceryService.getCategory();
		model.addAttribute("clist", catList);
		model.addAttribute("grocery", grocery);
		return "groceryForm";
	}

	@RequestMapping(value = "/submitGrocery.obj")
	public String addGrocery(
			@ModelAttribute(value = "grocery") @Valid Grocery grocery,
			BindingResult bindingResult, Model model) throws GroceryException {
		//System.out.println("--addGrocery--");
		//System.out.println(grocery);
		if (bindingResult.hasErrors()) {
			catList = groceryService.getCategory();
			model.addAttribute("clist", catList);
			return "groceryForm";
		} else {
			int output = groceryService.addGrocery(grocery);
			model.addAttribute("groceryId", grocery.getId());
			if (output == 1) {
				return "successAdd";
			} else {
				return "groceryFailed";
			}
		}
	}

	@RequestMapping(value = "/retreiveGrocery.obj")
	public String showGrocery(Model model) throws GroceryException {
		glist = groceryService.getGroceryList();
		model.addAttribute("glist", glist);
		//System.out.println(glist);
		return "showAllPage";
	}

	@RequestMapping(value = "/goHome.obj")
	public String goToHome(Model model) {
		return "index";
	}
	
	@ExceptionHandler(GroceryException.class)
	public String handleException(GroceryException e){
		//e.printStackTrace();
		return "groceryException";
	}
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e){
		//e.printStackTrace();
		return "dataException";
	}

}
