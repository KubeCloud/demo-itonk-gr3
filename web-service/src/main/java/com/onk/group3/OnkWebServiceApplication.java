package com.onk.group3;

import com.onk.group3.models.*;
import com.onk.group3.repositories.CampaignRepository;
import com.onk.group3.repositories.CartRepository;
import com.onk.group3.repositories.CatalogRepository;
import com.onk.group3.repositories.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootApplication
public class OnkWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnkWebServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initializeDb(
            CampaignRepository campaignRepository,
            CatalogRepository catalogRepository,
            CartRepository cartRepository,
            CountryRepository countryRepository
    ) {
		return (args) -> {
			initCatalogs(catalogRepository);
            initCarts(cartRepository);

			campaignRepository.deleteAll();
            countryRepository.deleteAll();

            countryRepository.save(new Country("Denmark", "da", "dan", "DKK", "kroner", BigDecimal.ONE, ""));
		};
	}

    private void initCarts(CartRepository repository) {
        repository.deleteAll();
        repository.save(new Cart(new Long(1), null, BigDecimal.ZERO, new Long(1)));
    }

    private void initCatalogs(CatalogRepository repository) {
		repository.deleteAll();
		repository.save(new Catalog(new Long(1), "Palm trees", getIds(1, 6)));
		repository.save(new Catalog(new Long(2), "Water plants", getIds(7, 6)));
		repository.save(new Catalog(new Long(3), "Shrubs", getIds(13, 6)));
	}

	private ArrayList<Long> getIds(long start, long length) {
        ArrayList<Long> ids = new ArrayList<Long>();

		for(long i = start; i < start + length; i++) {
            ids.add(i);
		}

        return ids;
	}
}
