package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.ejbs.ShoppingCartLogic;
import co.edu.uniandes.csw.marketplace.api.IShoppingCartLogic;
import co.edu.uniandes.csw.marketplace.converters.ShoppingCartConverter;
import co.edu.uniandes.csw.marketplace.dtos.ShoppingCartDTO;
import co.edu.uniandes.csw.marketplace.entities.ShoppingCartEntity;
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
public class ShoppingCartLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ShoppingCartEntity.class.getPackage())
                .addPackage(ShoppingCartDTO.class.getPackage())
                .addPackage(ShoppingCartConverter.class.getPackage())
                .addPackage(ShoppingCartLogic.class.getPackage())
                .addPackage(IShoppingCartLogic.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IShoppingCartLogic shoppingCartLogic;

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
        em.createQuery("delete from ShoppingCartEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ShoppingCartEntity> data = new ArrayList<ShoppingCartEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ShoppingCartEntity entity = new ShoppingCartEntity();
        	entity.setName(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createShoppingCartTest() {
        ShoppingCartDTO dto = new ShoppingCartDTO();
        dto.setName(generateRandom(String.class));

        ShoppingCartDTO result = shoppingCartLogic.createShoppingCart(dto);

        Assert.assertNotNull(result);

        ShoppingCartEntity entity = em.find(ShoppingCartEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getShoppingCartsTest() {
        List<ShoppingCartDTO> list = shoppingCartLogic.getShoppingCarts(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ShoppingCartDTO dto : list) {
            boolean found = false;
            for (ShoppingCartEntity entity : data) {
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
    public void getShoppingCartTest() {
        ShoppingCartEntity entity = data.get(0);
        ShoppingCartDTO dto = shoppingCartLogic.getShoppingCart(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
    }

    /**
     * @generated
     */
    @Test
    public void deleteShoppingCartTest() {
        ShoppingCartEntity entity = data.get(0);
        shoppingCartLogic.deleteShoppingCart(entity.getId());
        ShoppingCartEntity deleted = em.find(ShoppingCartEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateShoppingCartTest() {
        ShoppingCartEntity entity = data.get(0);

        ShoppingCartDTO dto = new ShoppingCartDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));

        shoppingCartLogic.updateShoppingCart(dto);

        ShoppingCartEntity resp = em.find(ShoppingCartEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
    }

    /**
     * @generated
     */
    @Test
    public void getShoppingCartPaginationTest() {
        //Page 1
        List<ShoppingCartDTO> dto1 = shoppingCartLogic.getShoppingCarts(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<ShoppingCartDTO> dto2 = shoppingCartLogic.getShoppingCarts(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (ShoppingCartDTO dto : dto1) {
            boolean found = false;
            for (ShoppingCartEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ShoppingCartDTO dto : dto2) {
            boolean found = false;
            for (ShoppingCartEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
}
