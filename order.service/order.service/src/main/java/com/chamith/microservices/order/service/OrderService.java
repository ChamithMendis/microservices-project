package com.chamith.microservices.order.service;

import com.chamith.microservices.order.client.InventoryClient;
import com.chamith.microservices.order.dto.OrderRequest;
import com.chamith.microservices.order.event.OrderPlacedEvent;
import com.chamith.microservices.order.model.Order;
import com.chamith.microservices.order.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate; /* to send messages from order service to kafka topic */

    public void placeOrder(OrderRequest orderRequest) {

        var isProductIsInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if (isProductIsInStock) {
            // map order request to order object
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());

            // save order to order repository
            orderRepository.save(order);

            // send message to kafka Topic
            // orderNumber, email
            OrderPlacedEvent orderPlacedEvent = new OrderPlacedEvent();
            orderPlacedEvent.setOrderNumber(order.getOrderNumber());
            orderPlacedEvent.setEmail(orderRequest.userDetails().email());
            orderPlacedEvent.setFirstName(orderRequest.userDetails().firstName());
            orderPlacedEvent.setFirstName(orderRequest.userDetails().lastName());
            kafkaTemplate.send("order-placed",orderPlacedEvent);
        } else {
         throw new RuntimeException("Product with sku code " + orderRequest.skuCode() + " is not in stock" );
        }
    }
}
