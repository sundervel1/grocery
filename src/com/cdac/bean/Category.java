package com.cdac.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grocery_category")
public class Category {
	@Id
	private String category;

	public Category() {
	}

	public Category(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Category [category=" + category + "]";
	}
}
