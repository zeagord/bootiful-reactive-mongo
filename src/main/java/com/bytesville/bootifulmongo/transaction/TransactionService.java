package com.bytesville.bootifulmongo.transaction;

import com.bytesville.bootifulmongo.customers.Customer;
import com.bytesville.bootifulmongo.customers.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class TransactionService {

  @Autowired CustomerRepository customerRepository;
  @Autowired TransactionRepository transactionRepository;

  public Flux<Transactions> getPagedTransactios(int page, int total) {
    return transactionRepository.getPagedTransactions(page, total);
  }

  public Flux<Transactions> getTransactionsByCustomer(String username) {
   return customerRepository.findByUsername(username)
       .map(Customer::getAccounts)
       .flatMapMany(accountIds -> transactionRepository
           .getTransactionByAccountIds(accountIds)
       );
  }

  public Flux<Transaction> getTransactions(String username, String movement) {
    return customerRepository.findByUsername(username)
        .map(Customer::getAccounts)
        .flatMapMany(accountIds -> transactionRepository
            .getTransactionsWithFilters(accountIds, movement)
        );
  }
}
