package com.bytesville.bootifulmongo.account;

import reactor.core.publisher.Flux;

public interface CustomAccountRepository {
  Flux<Account> getAccounts(int page, int num);
}
