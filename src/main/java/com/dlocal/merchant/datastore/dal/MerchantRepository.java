package com.dlocal.merchant.datastore.dal;

import com.dlocal.merchant.datastore.models.Merchant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MerchantRepository extends MongoRepository<Merchant, String> {
    public Merchant findByName(String firstName);
}
