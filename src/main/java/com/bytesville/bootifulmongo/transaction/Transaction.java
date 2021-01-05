package com.bytesville.bootifulmongo.transaction;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Transaction {
  private Integer amount;
  private Date date;
  private String symbol;
  @Field(value = "transaction_code")
  private String transactionCode;
  private BigDecimal price;
  private BigDecimal total;
}
