/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.repository;

/**
 *
 * @author Hau Exoty
 */
import com.ttp.pojos.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> getCategories();
    Category getCategoryById(int cateId);
    boolean addCategory(Category category);
}
