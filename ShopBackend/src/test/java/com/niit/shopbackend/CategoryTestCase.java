package com.niit.shopbackend;

import static org.junit.Assert.*;

import org.junit.Test;




import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shopbackend.config.DBConfig
import com.niit.shopbackend.model.Category;
import com.niit.shopbackend.dao.CategoryReposirory;


public class CategoryTestCase {

	@Autowired
	private static Category category;

	@Autowired
	private static CategoryReposirory categoryRepository;

	@BeforeClass
	public static void init() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				DBConfig.class);

		category = (Category) context.getBean("category");
		categoryService = (CategoryReposirory) context.getBean("categoryRepository");
	}

	@Test
	public void saveCategoryTest() {
		category.setName("LED");
		category.setDescription("Light emmiting diode");
		
		boolean flag = categoryRepository.save(category);
		
		Assert.assertEquals("save category test case", true, flag);
	}
	
	@Test
	public void getAllCategory(){
		List<Category> categoryList= categoryRepository.getAllCategory();
		System.out.println(categoryList);
		Assert.assertEquals("Get all category test", 2, categoryList.size());
	}


	
	
	
	
	

}
