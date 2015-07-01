package co.edu.uniandes.csw.marketplace.ejbs;

import co.edu.uniandes.csw.marketplace.api.IClientLogic;
import co.edu.uniandes.csw.marketplace.converters.ClientConverter;
import co.edu.uniandes.csw.marketplace.dtos.ClientDTO;
import co.edu.uniandes.csw.marketplace.entities.ClientEntity;
import java.util.List;
import javax.ejb.Stateless;

/**
 * @generated
 */
@Stateless
public class ClientLogic extends CrudLogic<ClientEntity> implements IClientLogic {

    /**
     * @generated
     */
    public ClientLogic() {
        entityClass = ClientEntity.class;
    }

    /**
     * @generated
     */
    public int countClients() {
        return count();
    }

    /**
     * @generated
     */
    public List<ClientDTO> getClients(Integer page, Integer maxRecords) {
        return ClientConverter.listEntity2DTO(findAll(page, maxRecords));
    }

    /**
     * @generated
     */
    public ClientDTO getClient(Long id) {
        return ClientConverter.fullEntity2DTO(find(id));
    }

    /**
     * @generated
     */
    public ClientDTO createClient(ClientDTO dto) {
        ClientEntity entity = ClientConverter.fullDTO2Entity(dto);
        create(entity);
        return ClientConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public ClientDTO updateClient(ClientDTO dto) {
        ClientEntity entity = update(ClientConverter.fullDTO2Entity(dto));
        return ClientConverter.fullEntity2DTO(entity);
    }

    /**
     * @generated
     */
    public void deleteClient(Long id) {
        delete(id);
    }
}
