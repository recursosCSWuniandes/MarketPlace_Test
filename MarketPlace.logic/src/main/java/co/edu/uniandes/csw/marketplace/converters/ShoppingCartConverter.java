package co.edu.uniandes.csw.marketplace.converters;

import co.edu.uniandes.csw.marketplace.dtos.ShoppingCartDTO;
import co.edu.uniandes.csw.marketplace.entities.ShoppingCartEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class ShoppingCartConverter {

    /**
     * @generated
     */
    private ShoppingCartConverter() {
    }

    /**
     * @param entity
     * @return
     * @generated
     */
    public static ShoppingCartDTO refEntity2DTO(ShoppingCartEntity entity) {
        if (entity != null) {
            ShoppingCartDTO dto = new ShoppingCartDTO();
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
    public static ShoppingCartEntity refDTO2Entity(ShoppingCartDTO dto) {
        if (dto != null) {
            ShoppingCartEntity entity = new ShoppingCartEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ShoppingCartDTO basicEntity2DTO(ShoppingCartEntity entity) {
        if (entity != null) {
            ShoppingCartDTO dto = new ShoppingCartDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    private static ShoppingCartEntity basicDTO2Entity(ShoppingCartDTO dto) {
        if (dto != null) {
            ShoppingCartEntity entity = new ShoppingCartEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ShoppingCartDTO fullEntity2DTO(ShoppingCartEntity entity) {
        if (entity != null) {
            ShoppingCartDTO dto = basicEntity2DTO(entity);
            return dto;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static ShoppingCartEntity fullDTO2Entity(ShoppingCartDTO dto) {
        if (dto != null) {
            ShoppingCartEntity entity = basicDTO2Entity(dto);
            return entity;
        } else {
            return null;
        }
    }

    /**
     * @generated
     */
    public static List<ShoppingCartDTO> listEntity2DTO(List<ShoppingCartEntity> entities) {
        List<ShoppingCartDTO> dtos = new ArrayList<ShoppingCartDTO>();
        if (entities != null) {
            for (ShoppingCartEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * @generated
     */
    public static List<ShoppingCartEntity> listDTO2Entity(List<ShoppingCartDTO> dtos) {
        List<ShoppingCartEntity> entities = new ArrayList<ShoppingCartEntity>();
        if (dtos != null) {
            for (ShoppingCartDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
