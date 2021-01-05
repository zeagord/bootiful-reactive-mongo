package com.bytesville.bootifulmongo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AccountController {

  @Autowired AccountService accountService;

  @GetMapping("/accounts")
  public @ResponseBody Flux<Account> getAccounts(){
    return accountService.fetchAccounts();
  }

  @GetMapping("/account/{id}")
  public Mono<Account> getAccounts(@PathVariable Long id){
    return accountService.getAccountById(id);
  }
}
