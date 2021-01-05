package com.bytesville.bootifulmongo.account;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository
    extends ReactiveMongoRepository<Account, String>, CustomAccountRepository {
  Mono<Account> findByAccountId(Long id);
}
