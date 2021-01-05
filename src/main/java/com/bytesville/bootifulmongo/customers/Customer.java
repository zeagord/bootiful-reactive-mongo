package com.bytesville.bootifulmongo.customers;

import java.util.Date;
import java.util.List;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("customers")
public class Customer {
  @Id
  private ObjectId id;

  private String username;

  private String name;

  private String address;

  private String email;

  private Date birthdate;

  private Boolean active;

  private List<Integer> accounts;

}
