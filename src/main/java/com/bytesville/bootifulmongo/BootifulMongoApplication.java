package com.bytesville.bootifulmongo;

import com.mongodb.WriteConcern;
import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class BootifulMongoApplication {

  @Autowired MongoClient mongoClient;

  @Value("spring.data.mongodb.uri")
  private String srvHost;

  public static void main(String[] args) {
    SpringApplication.run(BootifulMongoApplication.class, args);
  }



  @Bean
  public ReactiveMongoTemplate reactiveMongoTemplate() {
		ReactiveMongoTemplate reactiveMongoTemplate = new ReactiveMongoTemplate(mongoClient, "sample_analytics");
		reactiveMongoTemplate.setWriteConcern(WriteConcern.MAJORITY);
		return reactiveMongoTemplate;
  }

}