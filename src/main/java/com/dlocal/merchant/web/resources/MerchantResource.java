package com.dlocal.merchant.web.resources;

import com.dlocal.merchant.datastore.dal.MerchantRepository;
import com.dlocal.merchant.datastore.models.Merchant;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Optional;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "merchants")
@Path("/merchants")
public class MerchantResource {

    @Autowired
    private MerchantRepository repository;

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getEmployee(@PathParam("id") String id) {
        Optional<Merchant> merchantOpt = repository.findById(id);
        if (merchantOpt.isPresent()) {
            com.dlocal.merchant.web.model.Merchant merchantFEModel = new com.dlocal.merchant.web.model.Merchant();
            merchantFEModel.setId(merchantOpt.get().id);
            merchantFEModel.setName(merchantOpt.get().name);
            return Response.status(200).entity(merchantFEModel).build();
        }
        return Response.status(404).build();
    }
}
