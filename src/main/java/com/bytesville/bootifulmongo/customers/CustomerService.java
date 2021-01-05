package com.bytesville.bootifulmongo.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {

  @Autowired CustomerRepository customerRepository;

  Mono<Customer> getCustomers(String userName){
    return customerRepository.findByUsername(userName);
  }
}
