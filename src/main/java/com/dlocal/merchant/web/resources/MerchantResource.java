package com.dlocal.merchant.web.resources;

import com.dlocal.merchant.datastore.dal.MerchantRepository;
import com.dlocal.merchant.web.model.Merchant;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "merchants")
@Path("/merchants")
public class MerchantResource {

//    @Autowired
//    private MerchantRepository repository;
    private static Map<String, Merchant> DB = new HashMap<>();

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Merchant getEmployee(@PathParam("id") String id) {
//        com.dlocal.merchant.datastore.models.Merchant merchant = repository.findByName(id);
        Merchant merchantFE = DB.get(id);
//        merchantFE.setId(merchant.id);
//        merchantFE.setName(merchant.name);
        return merchantFE;
    }

    static
    {
        Merchant mer1 = new Merchant();
        mer1.setId("id1");
        mer1.setName("name");

        Merchant mer2 = new Merchant();
        mer2.setId("id2");
        mer2.setName("name2");

        DB.put(mer1.getId(), mer1);
        DB.put(mer2.getId(), mer2);
    }
}
