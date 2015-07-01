package co.edu.uniandes.csw.marketplace.service;

import co.edu.uniandes.csw.marketplace.api.IItemLogic;
import co.edu.uniandes.csw.marketplace.dtos.ItemDTO;
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
@Path("/items")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ItemService {

    @Inject private IItemLogic itemLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @GET
    public List<ItemDTO> getItems() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", itemLogic.countItems());
        }
        return itemLogic.getItems(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id}")
    public ItemDTO getItem(@PathParam("id") Long id) {
        return itemLogic.getItem(id);
    }

    /**
     * @generated
     */
    @POST
    public ItemDTO createItem(ItemDTO dto) {
        ItemDTO new_dto = itemLogic.createItem(dto);
        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            Logger.getLogger(ItemService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new_dto;
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id}")
    public ItemDTO updateItem(@PathParam("id") Long id, ItemDTO dto) {
        dto.setId(id);
        return itemLogic.updateItem(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id}")
    public void deleteItem(@PathParam("id") Long id) {
        itemLogic.deleteItem(id);
    }
}
