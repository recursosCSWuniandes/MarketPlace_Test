package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.IItemLogic;
import co.edu.uniandes.csw.marketplace.converters.ItemConverter;
import co.edu.uniandes.csw.marketplace.dtos.ItemDTO;
import co.edu.uniandes.csw.marketplace.entities.ItemEntity;
import java.util.List;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class ItemLogic extends CrudLogic<ItemEntity> implements IItemLogic {

    /**
     * @generated
     */
    public ItemLogic() {
        entityClass = ItemEntity.class;
    }

    /**
     * @generated
     */
    public int countItems() {
        return count();
    }

    /**
     * @generated
     */
    public List<ItemDTO> getItems(Integer page, Integer maxRecords) {
        return ItemConverter.listEntity2DTO(findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public ItemDTO getItem(Long id) {
        return ItemConverter.fullEntity2DTO(find(id));
    }

    /**
     * @generated
     */
    public ItemDTO createItem(ItemDTO dto) {
        ItemEntity entity = ItemConverter.fullDTO2Entity(dto);
        create(entity);
        return ItemConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public ItemDTO updateItem(ItemDTO dto) {
        ItemEntity entity = update(ItemConverter.fullDTO2Entity(dto));
        return ItemConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteItem(Long id) {
        delete(id);
    }
}
