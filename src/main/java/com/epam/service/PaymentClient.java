package com.epam.service;

import com.epam.common.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentClient {

    @Autowired
    private RestTemplate restTemplate;

    public Payment makePayment(Payment request){
        return restTemplate.postForObject("http://localhost:9191/payment/bookPayment", request, Payment.class);
    }
}
