package com.dlocal.merchant.datastore.dal;

import com.dlocal.merchant.datastore.models.Merchant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends PagingAndSortingRepository<Merchant, String> {
}
