package co.edu.uniandes.csw.marketplace.service;

import co.edu.uniandes.csw.marketplace.api.IClientLogic;
import co.edu.uniandes.csw.marketplace.dtos.ClientDTO;
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
@Path("/clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientService {

    @Inject private IClientLogic clientLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * @generated
     */
    @GET
    public List<ClientDTO> getClients() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", clientLogic.countClients());
        }
        return clientLogic.getClients(page, maxRecords);
    }

    /**
     * @generated
     */
    @GET
    @Path("{id}")
    public ClientDTO getClient(@PathParam("id") Long id) {
        return clientLogic.getClient(id);
    }

    /**
     * @generated
     */
    @POST
    public ClientDTO createClient(ClientDTO dto) {
        ClientDTO new_dto = clientLogic.createClient(dto);
        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new_dto;
    }

    /**
     * @generated
     */
    @PUT
    @Path("{id}")
    public ClientDTO updateClient(@PathParam("id") Long id, ClientDTO dto) {
        dto.setId(id);
        return clientLogic.updateClient(dto);
    }

    /**
     * @generated
     */
    @DELETE
    @Path("{id}")
    public void deleteClient(@PathParam("id") Long id) {
        clientLogic.deleteClient(id);
    }
}
