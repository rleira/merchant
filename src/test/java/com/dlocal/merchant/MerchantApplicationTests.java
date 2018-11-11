package com.dlocal.merchant;

import com.dlocal.merchant.datastore.dal.MerchantRepository;
import com.dlocal.merchant.datastore.models.Merchant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestContext.class})
@SpringBootTest
public class MerchantApplicationTests {

	@Autowired
	private MerchantRepository merchantRepository;

	@Before
	public void setUp() {
	}

	@Test
	public void add_NewMerchant() throws Exception {
		Merchant newMerchant = new Merchant();
		newMerchant.setId("123");
		newMerchant.setName("test");
		when(merchantRepository.save(newMerchant)).thenReturn(newMerchant);
	}
}
