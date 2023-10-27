package com.snort.repository;

import com.snort.model.OrderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineItemsRepository extends JpaRepository<OrderLineItems,Long> {
}
