package es.mhp.services;

import es.mhp.services.dto.ItemDTO;

import java.util.Set;

/**
 * Created by Edu on 24/02/2016.
 */
public interface IItemService {
    Set<ItemDTO> findAllItems();
    Set<ItemDTO> findAnyItems(String text);
    ItemDTO save(ItemDTO itemDTO);
    void delete(ItemDTO itemDTO);
}
