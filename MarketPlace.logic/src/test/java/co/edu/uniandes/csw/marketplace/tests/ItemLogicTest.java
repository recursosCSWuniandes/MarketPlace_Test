package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.ejbs.ItemLogic;
import co.edu.uniandes.csw.marketplace.api.IItemLogic;
import co.edu.uniandes.csw.marketplace.converters.ItemConverter;
import co.edu.uniandes.csw.marketplace.dtos.ItemDTO;
import co.edu.uniandes.csw.marketplace.entities.ItemEntity;
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
public class ItemLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ItemEntity.class.getPackage())
                .addPackage(ItemDTO.class.getPackage())
                .addPackage(ItemConverter.class.getPackage())
                .addPackage(ItemLogic.class.getPackage())
                .addPackage(IItemLogic.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IItemLogic itemLogic;

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
        em.createQuery("delete from ItemEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ItemEntity> data = new ArrayList<ItemEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ItemEntity entity = new ItemEntity();
        	entity.setName(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createItemTest() {
        ItemDTO dto = new ItemDTO();
        dto.setName(generateRandom(String.class));

        ItemDTO result = itemLogic.createItem(dto);

        Assert.assertNotNull(result);

        ItemEntity entity = em.find(ItemEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getItemsTest() {
        List<ItemDTO> list = itemLogic.getItems(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ItemDTO dto : list) {
            boolean found = false;
            for (ItemEntity entity : data) {
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
    public void getItemTest() {
        ItemEntity entity = data.get(0);
        ItemDTO dto = itemLogic.getItem(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
    }

    /**
     * @generated
     */
    @Test
    public void deleteItemTest() {
        ItemEntity entity = data.get(0);
        itemLogic.deleteItem(entity.getId());
        ItemEntity deleted = em.find(ItemEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateItemTest() {
        ItemEntity entity = data.get(0);

        ItemDTO dto = new ItemDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));

        itemLogic.updateItem(dto);

        ItemEntity resp = em.find(ItemEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getItemPaginationTest() {
        //Page 1
        List<ItemDTO> dto1 = itemLogic.getItems(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<ItemDTO> dto2 = itemLogic.getItems(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (ItemDTO dto : dto1) {
            boolean found = false;
            for (ItemEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ItemDTO dto : dto2) {
            boolean found = false;
            for (ItemEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
}
