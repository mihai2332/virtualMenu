package com.spliff.Virtualmenu.service;

import com.spliff.Virtualmenu.entity.Category;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest extends TestCase {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testGetAllCategories() {
        Set<Category> categories = categoryService.getAllCategories("phoenix");
        assertNotNull(categories);
    }
}