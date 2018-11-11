package com.dlocal.merchant.web.resources;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class RestConfiguration extends ResourceConfig {

    RestConfiguration () {
        register(MerchantResource.class);
    }
}
