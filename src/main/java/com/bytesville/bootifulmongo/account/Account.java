package com.bytesville.bootifulmongo.account;

import java.util.List;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("accounts")
public class Account {

  @Id
  private ObjectId id;

  @Field(value = "account_id")
  private Integer accountId;

  private Integer limit;

  private List<String> products;
}
