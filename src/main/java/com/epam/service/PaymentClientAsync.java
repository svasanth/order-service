package com.epam.service;

import com.epam.common.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class PaymentClientAsync {

    @Autowired
    private PaymentClient paymentClient;

    @Async
    public CompletableFuture<Payment> makePayment(Payment request){
        Payment response = paymentClient.makePayment(request);

        return CompletableFuture.completedFuture(response);
    }
}
