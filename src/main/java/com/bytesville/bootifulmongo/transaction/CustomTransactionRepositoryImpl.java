package com.bytesville.bootifulmongo.transaction;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveFluentMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import reactor.core.publisher.Flux;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.unwind;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

public class CustomTransactionRepositoryImpl implements CustomTransactionRepository {
  @Autowired ReactiveMongoTemplate mongoTemplate;

  @Override public Flux<Transactions> getPagedTransactions(int page, int num) {
    return mongoTemplate.findAll(Transactions.class)
        .skip(page * num)
        .limitRequest(num);
  }

  @Override public Flux<Transactions> getTransactionByAccountIds(List<Integer> accountIds) {
    return mongoTemplate.query(Transactions.class)
        .matching(query(where("account_id").in(accountIds)))
        .all();
  }

  @Override
  public Flux<Transaction> getTransactionsWithFilters(List<Integer> accountIds, String movement) {
    Aggregation transactionAggregation = newAggregation(
        match(where("account_id").in(accountIds)),
        unwind("transactions"),
        match(where("transactions.transaction_code").is(movement)),
        project("transactions.date", "transactions.amount", "transactions.transaction_code", "transactions.symbol", "transactions.price", "transactions.total")
    );

    Flux<Transaction>
        results = mongoTemplate.aggregate(transactionAggregation, "transactions", Transaction.class);
    return results;
  }

}

