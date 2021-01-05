package com.bytesville.bootifulmongo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class CustomAccountRepositoryImpl implements CustomAccountRepository {
  @Autowired ReactiveMongoTemplate mongoTemplate;
  @Override public Flux<Account> getAccounts(int page, int num) {
    return mongoTemplate.findAll(Account.class)
        .skip(page * num)
        .limitRequest(num);
  }
}
