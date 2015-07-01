package co.edu.uniandes.csw.marketplace.converters;

import co.edu.uniandes.csw.marketplace.dtos.ItemDTO;
import co.edu.uniandes.csw.marketplace.entities.ItemEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class ItemConverter {

    /**
     * @generated
     */
    private ItemConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static ItemDTO refEntity2DTO(ItemEntity entity) {
        if (entity != null) {
            ItemDTO dto = new ItemDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @param dto
     * @return
     * @generated
     */
    public static ItemEntity refDTO2Entity(ItemDTO dto) {
        if (dto != null) {
            ItemEntity entity = new ItemEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ItemDTO basicEntity2DTO(ItemEntity entity) {
        if (entity != null) {
            ItemDTO dto = new ItemDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setProduct(ProductConverter.refEntity2DTO(entity.getProduct()));
            dto.setShoppingCart(ShoppingCartConverter.refEntity2DTO(entity.getShoppingCart()));

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ItemEntity basicDTO2Entity(ItemDTO dto) {
        if (dto != null) {
            ItemEntity entity = new ItemEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setProduct(ProductConverter.refDTO2Entity(dto.getProduct()));
            entity.setShoppingCart(ShoppingCartConverter.refDTO2Entity(dto.getShoppingCart()));

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ItemDTO fullEntity2DTO(ItemEntity entity) {
        if (entity != null) {
            ItemDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ItemEntity fullDTO2Entity(ItemDTO dto) {
        if (dto != null) {
            ItemEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static List<ItemDTO> listEntity2DTO(List<ItemEntity> entities) {
        List<ItemDTO> dtos = new ArrayList<ItemDTO>();
        if (entities != null) {
            for (ItemEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<ItemEntity> listDTO2Entity(List<ItemDTO> dtos) {
        List<ItemEntity> entities = new ArrayList<ItemEntity>();
        if (dtos != null) {
            for (ItemDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
