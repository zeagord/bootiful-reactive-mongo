package com.bytesville.bootifulmongo.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class TransactionController {

  @Autowired TransactionService transactionService;

  @GetMapping("/transactions")
  public Flux<Transactions> getPagedTransactions(@RequestParam int page, @RequestParam int total) {
    return transactionService.getPagedTransactios(page, total);
  }

  @GetMapping("/transaction")
  public Flux<Transactions> getTransactionsByCustomer(@RequestParam String username) {
    return transactionService.getTransactionsByCustomer(username);
  }

  @GetMapping("/transactions/{username}")
  public Flux<Transaction> getTransactions(@PathVariable String username
      , @RequestParam String movement) {
    return transactionService.getTransactions(username, movement);
  }
}
