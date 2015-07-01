package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.IShoppingCartLogic;
import co.edu.uniandes.csw.marketplace.converters.ShoppingCartConverter;
import co.edu.uniandes.csw.marketplace.dtos.ShoppingCartDTO;
import co.edu.uniandes.csw.marketplace.entities.ShoppingCartEntity;
import java.util.List;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class ShoppingCartLogic extends CrudLogic<ShoppingCartEntity> implements IShoppingCartLogic {

    /**
     * @generated
     */
    public ShoppingCartLogic() {
        entityClass = ShoppingCartEntity.class;
    }

    /**
     * @generated
     */
    public int countShoppingCarts() {
        return count();
    }

    /**
     * @generated
     */
    public List<ShoppingCartDTO> getShoppingCarts(Integer page, Integer maxRecords) {
        return ShoppingCartConverter.listEntity2DTO(findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public ShoppingCartDTO getShoppingCart(Long id) {
        return ShoppingCartConverter.fullEntity2DTO(find(id));
    }

    /**
     * @generated
     */
    public ShoppingCartDTO createShoppingCart(ShoppingCartDTO dto) {
        ShoppingCartEntity entity = ShoppingCartConverter.fullDTO2Entity(dto);
        create(entity);
        return ShoppingCartConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public ShoppingCartDTO updateShoppingCart(ShoppingCartDTO dto) {
        ShoppingCartEntity entity = update(ShoppingCartConverter.fullDTO2Entity(dto));
        return ShoppingCartConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteShoppingCart(Long id) {
        delete(id);
    }
}
