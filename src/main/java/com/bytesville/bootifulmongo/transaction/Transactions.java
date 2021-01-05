package com.bytesville.bootifulmongo.transaction;

import java.util.Date;
import java.util.List;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("transactions")
public class Transactions {

  @Id
  private ObjectId id;

  @Field(value = "account_id")
  private Integer accountId;

  private Integer transaction_count;

  @Field(value = "bucket_start_date")
  private Date bucketStartDate;

  @Field(value = "bucket_end_date")
  private Date bucketEndDate;

  private List<Transaction> transactions;

}
