package es.mhp.services.impl;

import es.mhp.dao.ICategoryDao;
import es.mhp.entities.Category;
import es.mhp.services.ICategoryService;
import es.mhp.services.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Edu on 24/02/2016.
 */
@Service
public class ServiceCategoryImpl implements ICategoryService {

    @Autowired
    private ICategoryDao iCategoryDao;

    public Set<CategoryDTO> findAllCategories() {
        Set<Category> categorySet = iCategoryDao.findAll();

        Set<CategoryDTO> categoryDTOs = new HashSet<>();

        for (Category category : categorySet){
            categoryDTOs.add(new CategoryDTO(category));
        }

        return categoryDTOs;
    }

    public Set<CategoryDTO> findAllCategories(Category category) {
        Set<Category> categorySet = iCategoryDao.findAll(category);

        Set<CategoryDTO> categoryDTOs = new HashSet<>();

        for (Category currentCategory : categorySet){
            categoryDTOs.add(new CategoryDTO(currentCategory));
        }

        return categoryDTOs;
    }

    public Set<CategoryDTO> findAnyCategories(Category category) {
        Set<Category> categorySet = iCategoryDao.findAny(category);

        Set<CategoryDTO> categoryDTOs = new HashSet<>();

        for (Category currentCategory : categorySet){
            categoryDTOs.add(new CategoryDTO(currentCategory));
        }

        return categoryDTOs;
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category address = iCategoryDao.findById(categoryDTO.getCategoryId());

        if (address != null){
            iCategoryDao.update(categoryDTO.ToEntity(address));
        } else {
            address = new Category();
            iCategoryDao.save(address);
        }
        return new CategoryDTO(address);
    }

    @Override
    public void delete(CategoryDTO categoryDTO) {
        iCategoryDao.deleteById(categoryDTO.getCategoryId());
    }

    @Override
    public CategoryDTO findCategoryById(String id) {
        return new CategoryDTO(iCategoryDao.findById(id));
    }
}
