package com.bytesville.bootifulmongo.customers;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
  Mono<Customer> findByUsername(String username);
}
