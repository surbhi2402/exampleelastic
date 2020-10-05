package com.ttn.elastic.service;

import com.ttn.elastic.entity.Greeting;
import java.util.List;

public interface GreetingService {

  List<Greeting> getAll();
  Greeting findOne(String id);
  Greeting create(Greeting greeting);
  Greeting update(Greeting greeting);
  List<Greeting> getGreetingByUsername(String username);
  void delete(String id);

}
