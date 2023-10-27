package com.snort;

import com.snort.model.Inventory;
import com.snort.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
//		return args -> {
//			Inventory inventory = new Inventory();
//			inventory.setSkuCode("Iphone-13");
//			inventory.setQuantity(13);
//
//			Inventory inventory1 = new Inventory();
//			inventory1.setSkuCode("Smart -Tv");
//			inventory1.setQuantity(0);
//
//			Inventory inventory2 = new Inventory();
//			inventory2.setSkuCode("Laptop");
//			inventory2.setQuantity(10);
//
//			inventoryRepository.save(inventory);
//			inventoryRepository.save(inventory1);
//			inventoryRepository.save(inventory2);
//
//		};
//	}
}
