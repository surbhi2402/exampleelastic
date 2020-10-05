package com.ttn.elastic.entity;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "index", type = "greetings")
public class Greeting implements Serializable {

  @Id
  private String id;

  private String username;

  private String message;

  public Greeting() {
  }

  public String getId() {
    return id;
  }

  public Greeting setId(String id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public Greeting setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getMessage() {
    return message;
  }

  public Greeting setMessage(String message) {
    this.message = message;
    return this;
  }
}
