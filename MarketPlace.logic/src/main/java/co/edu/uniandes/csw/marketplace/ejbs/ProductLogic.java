package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.IProductLogic;
import co.edu.uniandes.csw.marketplace.converters.ProductConverter;
import co.edu.uniandes.csw.marketplace.dtos.ProductDTO;
import co.edu.uniandes.csw.marketplace.entities.ProductEntity;
import java.util.List;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class ProductLogic extends CrudLogic<ProductEntity> implements IProductLogic {

    /**
     * @generated
     */
    public ProductLogic() {
        entityClass = ProductEntity.class;
    }

    /**
     * @generated
     */
    public int countProducts() {
        return count();
    }

    /**
     * @generated
     */
    public List<ProductDTO> getProducts(Integer page, Integer maxRecords) {
        return ProductConverter.listEntity2DTO(findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public ProductDTO getProduct(Long id) {
        return ProductConverter.fullEntity2DTO(find(id));
    }

    /**
     * @generated
     */
    public ProductDTO createProduct(ProductDTO dto) {
        ProductEntity entity = ProductConverter.fullDTO2Entity(dto);
        create(entity);
        return ProductConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public ProductDTO updateProduct(ProductDTO dto) {
        ProductEntity entity = update(ProductConverter.fullDTO2Entity(dto));
        return ProductConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteProduct(Long id) {
        delete(id);
    }
}
