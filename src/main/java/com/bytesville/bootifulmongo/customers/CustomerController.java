package com.bytesville.bootifulmongo.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {
  @Autowired CustomerService customerService;

  @GetMapping("/customer/{userName}")
  public Mono<Customer> getCustomer(@PathVariable String userName) {
    return customerService.getCustomers(userName);
  }
}
