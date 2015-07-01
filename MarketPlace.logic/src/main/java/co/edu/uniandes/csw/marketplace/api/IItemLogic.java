package co.edu.uniandes.csw.marketplace.api;

import co.edu.uniandes.csw.marketplace.dtos.ItemDTO;
import java.util.List;

public interface IItemLogic {
    public int countItems();
    public List<ItemDTO> getItems(Integer page, Integer maxRecords);
    public ItemDTO getItem(Long id);
    public ItemDTO createItem(ItemDTO dto);
    public ItemDTO updateItem(ItemDTO dto);
    public void deleteItem(Long id);
}
