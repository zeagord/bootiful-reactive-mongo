package com.bytesville.bootifulmongo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountService {

  @Autowired AccountRepository accountRepository;

  public Flux<Account> fetchAccounts(){
    return accountRepository.getAccounts(1, 10);
  }


  public Mono<Account> getAccountById(Long id){
    return accountRepository.findByAccountId(id);
  }
}
