package com.ttn.elastic.dao;

import com.ttn.elastic.entity.Greeting;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface GreetingRepository extends ElasticsearchRepository<Greeting, String> {

  List<Greeting> findByUsername(String username);
}
