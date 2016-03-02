package es.mhp.dao;

import es.mhp.entities.SellerContactInfo;

/**
 * Created by Edu on 12/02/2016.
 */
public interface ISellerDao extends IPetshopGenericDao<SellerContactInfo> {
    SellerContactInfo findById(int id);
    void deleteById(int id);
}
