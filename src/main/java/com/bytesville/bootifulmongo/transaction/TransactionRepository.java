package com.bytesville.bootifulmongo.transaction;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepository
    extends ReactiveMongoRepository<Transactions, String>, CustomTransactionRepository {}
