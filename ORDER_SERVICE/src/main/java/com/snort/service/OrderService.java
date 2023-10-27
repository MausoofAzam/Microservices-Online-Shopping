package com.snort.service;

import com.snort.dto.InventoryResponse;
import com.snort.dto.OrderLineItemsDto;
import com.snort.dto.OrderRequest;
import com.snort.model.Order;
import com.snort.model.OrderLineItems;
import com.snort.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream().map(orderLineItemsDto -> mapToDto(orderLineItemsDto)).collect(Collectors.toList());
        order.setOrderLineItemsList(orderLineItems);
//        call order service and place order if the order is in stock
        List<String> skuCodes = order.getOrderLineItemsList().stream().map(orderLineItem -> orderLineItem.getSkuCode()).toList();


        InventoryResponse[] inventoryResponseArray = webClient.get()
                .uri("http://localhost:8183/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
        Boolean allProductsInStock = Arrays.stream(inventoryResponseArray).allMatch(inventoryResponse -> inventoryResponse.isInStock());

        if (allProductsInStock) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in Stock, Please Try again Later!!");
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        return orderLineItems;
    }
}
