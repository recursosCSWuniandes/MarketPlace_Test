package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.ejbs.ClientLogic;
import co.edu.uniandes.csw.marketplace.api.IClientLogic;
import co.edu.uniandes.csw.marketplace.converters.ClientConverter;
import co.edu.uniandes.csw.marketplace.dtos.ClientDTO;
import co.edu.uniandes.csw.marketplace.entities.ClientEntity;
import static co.edu.uniandes.csw.marketplace.tests._TestUtil.*;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ClientLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ClientEntity.class.getPackage())
                .addPackage(ClientDTO.class.getPackage())
                .addPackage(ClientConverter.class.getPackage())
                .addPackage(ClientLogic.class.getPackage())
                .addPackage(IClientLogic.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IClientLogic clientLogic;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * @generated
     */
    @Before
    public void configTest() {
        System.out.println("em: " + em);
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from ClientEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ClientEntity> data = new ArrayList<ClientEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ClientEntity entity = new ClientEntity();
        	entity.setName(generateRandom(String.class));
        	entity.setPhone(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createClientTest() {
        ClientDTO dto = new ClientDTO();
        dto.setName(generateRandom(String.class));
        dto.setPhone(generateRandom(String.class));

        ClientDTO result = clientLogic.createClient(dto);

        Assert.assertNotNull(result);

        ClientEntity entity = em.find(ClientEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getPhone(), entity.getPhone());
    }

    /**
     * @generated
     */
    @Test
    public void getClientsTest() {
        List<ClientDTO> list = clientLogic.getClients(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ClientDTO dto : list) {
            boolean found = false;
            for (ClientEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * @generated
     */
    @Test
    public void getClientTest() {
        ClientEntity entity = data.get(0);
        ClientDTO dto = clientLogic.getClient(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getPhone(), dto.getPhone());
    }

    /**
     * @generated
     */
    @Test
    public void deleteClientTest() {
        ClientEntity entity = data.get(0);
        clientLogic.deleteClient(entity.getId());
        ClientEntity deleted = em.find(ClientEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateClientTest() {
        ClientEntity entity = data.get(0);

        ClientDTO dto = new ClientDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setPhone(generateRandom(String.class));

        clientLogic.updateClient(dto);

        ClientEntity resp = em.find(ClientEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getPhone(), resp.getPhone());
    }

    /**
     * @generated
     */
    @Test
    public void getClientPaginationTest() {
        //Page 1
        List<ClientDTO> dto1 = clientLogic.getClients(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<ClientDTO> dto2 = clientLogic.getClients(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (ClientDTO dto : dto1) {
            boolean found = false;
            for (ClientEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ClientDTO dto : dto2) {
            boolean found = false;
            for (ClientEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
}
