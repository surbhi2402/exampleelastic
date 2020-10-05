package com.ttn.elastic.service.impl;

import com.google.common.collect.Lists;
import com.ttn.elastic.dao.GreetingRepository;
import com.ttn.elastic.entity.Greeting;
import com.ttn.elastic.service.GreetingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceBean implements GreetingService {

  @Autowired
  private GreetingRepository repository;

  @Override
  public List<Greeting> getAll() {
    return Lists.newArrayList(repository.findAll());
  }

  @Override
  public Greeting findOne(String id) {
    return repository.findOne(id);
  }

  @Override
  public Greeting create(Greeting greeting) {
    return repository.save(greeting);
  }

  @Override
  public Greeting update(Greeting greeting) {
    Greeting persitedGreeting = repository.findOne(greeting.getId());
    if(persitedGreeting == null) {
      return null;
    }
    return repository.save(greeting);
  }

  @Override
  public List<Greeting> getGreetingByUsername(String username) {
    return repository.findByUsername(username);
  }

  @Override
  public void delete(String id) {
    repository.delete(id);
  }
}
