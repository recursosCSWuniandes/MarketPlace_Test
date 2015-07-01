package co.edu.uniandes.csw.marketplace.service;

import co.edu.uniandes.csw.marketplace.api.IShoppingCartLogic;
import co.edu.uniandes.csw.marketplace.dtos.ShoppingCartDTO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * @generated
 */
@Path("/shoppingCarts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ShoppingCartService {

    @Inject private IShoppingCartLogic shoppingCartLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @GET
    public List<ShoppingCartDTO> getShoppingCarts() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", shoppingCartLogic.countShoppingCarts());
        }
        return shoppingCartLogic.getShoppingCarts(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id}")
    public ShoppingCartDTO getShoppingCart(@PathParam("id") Long id) {
        return shoppingCartLogic.getShoppingCart(id);
    }

    /**
     * @generated
     */
    @POST
    public ShoppingCartDTO createShoppingCart(ShoppingCartDTO dto) {
        ShoppingCartDTO new_dto = shoppingCartLogic.createShoppingCart(dto);
        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            Logger.getLogger(ShoppingCartService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new_dto;
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id}")
    public ShoppingCartDTO updateShoppingCart(@PathParam("id") Long id, ShoppingCartDTO dto) {
        dto.setId(id);
        return shoppingCartLogic.updateShoppingCart(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id}")
    public void deleteShoppingCart(@PathParam("id") Long id) {
        shoppingCartLogic.deleteShoppingCart(id);
    }
}
