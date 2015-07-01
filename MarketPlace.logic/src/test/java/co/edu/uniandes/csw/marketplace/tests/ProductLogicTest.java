package co.edu.uniandes.csw.marketplace.tests;

import co.edu.uniandes.csw.marketplace.ejbs.ProductLogic;
import co.edu.uniandes.csw.marketplace.api.IProductLogic;
import co.edu.uniandes.csw.marketplace.converters.ProductConverter;
import co.edu.uniandes.csw.marketplace.dtos.ProductDTO;
import co.edu.uniandes.csw.marketplace.entities.ProductEntity;
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
public class ProductLogicTest {
    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ProductEntity.class.getPackage())
                .addPackage(ProductDTO.class.getPackage())
                .addPackage(ProductConverter.class.getPackage())
                .addPackage(ProductLogic.class.getPackage())
                .addPackage(IProductLogic.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private IProductLogic productLogic;

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
        em.createQuery("delete from ProductEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ProductEntity> data = new ArrayList<ProductEntity>();

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ProductEntity entity = new ProductEntity();
        	entity.setName(generateRandom(String.class));
        	entity.setPrice(generateRandom(Integer.class));
        	entity.setDescription(generateRandom(String.class));
        	entity.setType(generateRandom(String.class));
        	entity.setImage(generateRandom(String.class));
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createProductTest() {
        ProductDTO dto = new ProductDTO();
        dto.setName(generateRandom(String.class));
        dto.setPrice(generateRandom(Integer.class));
        dto.setDescription(generateRandom(String.class));
        dto.setType(generateRandom(String.class));
        dto.setImage(generateRandom(String.class));

        ProductDTO result = productLogic.createProduct(dto);

        Assert.assertNotNull(result);

        ProductEntity entity = em.find(ProductEntity.class, result.getId());

        Assert.assertEquals(dto.getName(), entity.getName());
        Assert.assertEquals(dto.getPrice(), entity.getPrice());
        Assert.assertEquals(dto.getDescription(), entity.getDescription());
        Assert.assertEquals(dto.getType(), entity.getType());
        Assert.assertEquals(dto.getImage(), entity.getImage());
    }

    /**
     * @generated
     */
    @Test
    public void getProductsTest() {
        List<ProductDTO> list = productLogic.getProducts(null, null);
        Assert.assertEquals(data.size(), list.size());
        for (ProductDTO dto : list) {
            boolean found = false;
            for (ProductEntity entity : data) {
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
    public void getProductTest() {
        ProductEntity entity = data.get(0);
        ProductDTO dto = productLogic.getProduct(entity.getId());
        Assert.assertNotNull(dto);
        Assert.assertEquals(entity.getName(), dto.getName());
        Assert.assertEquals(entity.getPrice(), dto.getPrice());
        Assert.assertEquals(entity.getDescription(), dto.getDescription());
        Assert.assertEquals(entity.getType(), dto.getType());
        Assert.assertEquals(entity.getImage(), dto.getImage());
    }

    /**
     * @generated
     */
    @Test
    public void deleteProductTest() {
        ProductEntity entity = data.get(0);
        productLogic.deleteProduct(entity.getId());
        ProductEntity deleted = em.find(ProductEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateProductTest() {
        ProductEntity entity = data.get(0);

        ProductDTO dto = new ProductDTO();

        dto.setId(entity.getId());
        dto.setName(generateRandom(String.class));
        dto.setPrice(generateRandom(Integer.class));
        dto.setDescription(generateRandom(String.class));
        dto.setType(generateRandom(String.class));
        dto.setImage(generateRandom(String.class));

        productLogic.updateProduct(dto);

        ProductEntity resp = em.find(ProductEntity.class, entity.getId());

        Assert.assertEquals(dto.getName(), resp.getName());
        Assert.assertEquals(dto.getPrice(), resp.getPrice());
        Assert.assertEquals(dto.getDescription(), resp.getDescription());
        Assert.assertEquals(dto.getType(), resp.getType());
        Assert.assertEquals(dto.getImage(), resp.getImage());
    }

    /**
     * @generated
     */
    @Test
    public void getProductPaginationTest() {
        //Page 1
        List<ProductDTO> dto1 = productLogic.getProducts(1, 2);
        Assert.assertNotNull(dto1);
        Assert.assertEquals(2, dto1.size());
        //Page 2
        List<ProductDTO> dto2 = productLogic.getProducts(2, 2);
        Assert.assertNotNull(dto2);
        Assert.assertEquals(1, dto2.size());

        for (ProductDTO dto : dto1) {
            boolean found = false;
            for (ProductEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }

        for (ProductDTO dto : dto2) {
            boolean found = false;
            for (ProductEntity entity : data) {
                if (dto.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
}
