package es.mhp.dao;

import es.mhp.entities.Category;

/**
 * Created by Edu on 12/02/2016.
 */
public interface ICategoryDao extends IPetshopGenericDao<Category>{
    Category findById(String id);
}