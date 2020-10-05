package com.ttn.elastic.dao;

import com.ttn.elastic.entity.Customer;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

  List<Customer> findByFirstname(String firstName);
}
