package com.snort;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snort.dto.ProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.web.servlet.function.ServerResponse.status;

//@SpringBootTest
//@Testcontainers
//@AutoConfigureMockMvc
//class ProductServiceApplicationTests {
//
//	@Container
//	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Autowired
//	private ObjectMapper objectMapper;
//
//	@DynamicPropertySource
//	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
//		dynamicPropertyRegistry.add("spring.data.mongodb.uri",mongoDBContainer::getReplicaSetUrl);
//	}
//
//
//	@Test
//	void shouldCreateProducts() throws Exception {
//		ProductRequest productRequest =getProductRequest();
//		String  productRequestString = objectMapper.writeValueAsString(productRequest);
//		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(productRequestString))
//				.andExpect((ResultMatcher) status(201));
//	}
//
//	private ProductRequest getProductRequest() {
//		return ProductRequest.builder()
//				.name("iphone 13")
//				.description("iphone 13")
//				.price(BigDecimal.valueOf(15000.00))
//				.build();
//	}

//}
