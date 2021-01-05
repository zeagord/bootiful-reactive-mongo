package com.bytesville.bootifulmongo.transaction;

import java.util.List;
import reactor.core.publisher.Flux;

public interface CustomTransactionRepository {

  Flux<Transactions> getPagedTransactions(int page, int num);

  Flux<Transactions> getTransactionByAccountIds(List<Integer> accountId);

  Flux<Transaction> getTransactionsWithFilters(List<Integer> accountId, String movement);

}
