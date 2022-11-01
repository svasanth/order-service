package com.epam.service;

import com.epam.common.Payment;
import com.epam.common.TransactionRequest;
import com.epam.common.TransactionResponse;
import com.epam.entity.Order;
import com.epam.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void testSaveOrder(){
        Order order = new Order(123, "123", 12, 12);
        Payment payment = new Payment(123, "success", "abctanid", 123, 123);
        Mockito.when(restTemplate.postForObject(Mockito.any(String.class), Mockito.any(TransactionRequest.class), Mockito.eq(Payment.class))).thenReturn(payment);
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(order);
        TransactionResponse response = orderService.saveOrder(new TransactionRequest(order, new Payment()));

        Assertions.assertEquals(order.getName(), response.getOrder().getName());
    }

}
