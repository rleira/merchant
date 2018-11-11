package com.dlocal.merchant;

import com.dlocal.merchant.datastore.dal.MerchantRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;

public class TestContext {

    @Bean
    public MerchantRepository mockServices() {
        return Mockito.mock(MerchantRepository.class);
    }
}
