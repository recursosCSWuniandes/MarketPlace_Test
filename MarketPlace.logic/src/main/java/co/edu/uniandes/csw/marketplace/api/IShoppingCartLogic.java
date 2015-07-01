package co.edu.uniandes.csw.marketplace.api;

import co.edu.uniandes.csw.marketplace.dtos.ShoppingCartDTO;
import java.util.List;

public interface IShoppingCartLogic {
    public int countShoppingCarts();
    public List<ShoppingCartDTO> getShoppingCarts(Integer page, Integer maxRecords);
    public ShoppingCartDTO getShoppingCart(Long id);
    public ShoppingCartDTO createShoppingCart(ShoppingCartDTO dto);
    public ShoppingCartDTO updateShoppingCart(ShoppingCartDTO dto);
    public void deleteShoppingCart(Long id);
}
