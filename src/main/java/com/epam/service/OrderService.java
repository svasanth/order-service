package com.epam.service;

import com.epam.common.Payment;
import com.epam.common.TransactionRequest;
import com.epam.common.TransactionResponse;
import com.epam.entity.Order;
import com.epam.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request){
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        Payment paymentResponse = restTemplate.postForObject("http://localhost:9191/payment/bookPayment", request, Payment.class);
        String response = paymentResponse.getPaymentStatus().equals("success")? "Payment Success, Order Placed" : "Payment Failed, Order added to Cart";
        return new TransactionResponse(order, paymentResponse.getTransactionId(), paymentResponse.getAmount(), response);
    }

}
