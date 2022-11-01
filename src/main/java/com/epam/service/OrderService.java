package com.epam.service;

import com.epam.common.Employee;
import com.epam.common.Payment;
import com.epam.common.TransactionRequest;
import com.epam.common.TransactionResponse;
import com.epam.entity.Order;
import com.epam.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentClientAsync paymentClientAsync;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolExecutor;

    public TransactionResponse saveOrder(TransactionRequest request) throws ExecutionException, InterruptedException {
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        System.out.println("Get PoolSize() Size:"+threadPoolExecutor.getPoolSize());
        //System.out.println("Get MaximumPoolSize():"+threadPoolExecutor.getMaximumPoolSize());
        System.out.println("Get CorePoolSize() Size:"+threadPoolExecutor.getCorePoolSize());
        List<CompletableFuture<Payment>> results = multipleCalls(payment);
        CompletableFuture<Payment> future = paymentClientAsync.makePayment(payment);
        System.out.println("Get PoolSize() Size:"+threadPoolExecutor.getPoolSize());
        //System.out.println("Get MaximumPoolSize():"+threadPoolExecutor.getMaximumPoolSize());
        System.out.println("Get CorePoolSize() Size:"+threadPoolExecutor.getCorePoolSize());
        System.out.println(future.isDone());
        Payment paymentResponse = future.get();//restTemplate.postForObject("http://localhost:9191/payment/bookPayment", request, Payment.class);
        String response = paymentResponse.getPaymentStatus().equals("success")? "Payment Success, Order Placed" : "Payment Failed, Order added to Cart";
        orderRepository.save(request.getOrder());
        return new TransactionResponse(order, paymentResponse.getTransactionId(), paymentResponse.getAmount(), response);
    }

    private List<CompletableFuture<Payment>> multipleCalls(Payment payment){
        List<CompletableFuture<Payment>> results = new ArrayList<>();
        for(int i=0; i<1000; i++){
            CompletableFuture<Payment> future = paymentClientAsync.makePayment(payment);
            results.add(future);
        }
        return results;
    }

    private void buildEmployee(){
        Employee.EmployeeBuilder employeeBuilder = new Employee.EmployeeBuilder();
        Employee emp = employeeBuilder.setName("").build();
    }

}
