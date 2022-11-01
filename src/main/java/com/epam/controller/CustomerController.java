package com.epam.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Customer> getAllCustomers() {
        //Get all Customers from db
        return new ArrayDeque<>();
    }

    @GetMapping("/{customerId}")
    public Collection<Customer> getCustomer(@PathVariable("customerId") String customerId) {
        //Get all Customers from db
        return new ArrayDeque<>();
    }

    @GetMapping("/{customerId}/contacts")
    public Collection<Customer> getContactDetailsByCustomerId(@PathVariable("customerId") String customerId) {
        //Get all Customers from db
        return new ArrayDeque<>();
    }

    @DeleteMapping("/{customerId}/contacts")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContactsByCustomerId(@PathVariable("customerId") String customerId, @RequestHeader HttpHeaders httpHeaders) {
        httpHeaders.getFirst(HttpHeaders.ACCEPT_LANGUAGE);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_LANGUAGE, Locale.ENGLISH.getDisplayLanguage());
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ResponseEntity.ok().headers(headers).body(new Customer());
        //Get all Customers from db
    }
}

class Customer {
    List<ContactDetails> contactDetailsList;
}

class ContactDetails {

}