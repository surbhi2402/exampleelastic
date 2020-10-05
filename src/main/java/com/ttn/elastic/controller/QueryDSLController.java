package com.ttn.elastic.controller;

import com.ttn.elastic.entity.Customer;
import com.ttn.elastic.service.QueryDSLService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryDSLController {

  @Autowired
  private QueryDSLService service;

  @GetMapping("/searchMultiField/{firstname}/{age}")
  public List<Customer> searchByMultiField(@PathVariable("firstname") String firstname,
      @PathVariable("age") int age) {
    return service.searchByMultiFields(firstname, age);
  }

  @GetMapping("/customSearch/{firstname}")
  public List<Customer> getCustomer(@PathVariable("firstname") String firstname) {
    return service.getCustomerSearchData(firstname);
  }

  @GetMapping("/search/{text}")
  public List<Customer> doMultiMatchQuery(@PathVariable("text") String text) {
    return service.multiMatchQuery(text);
  }

  @GetMapping("/and-operator/{firstname}/{lastname}")
  public List<Customer> fetchCustomerListByAndOperator(@PathVariable("firstname") String firstname,
      @PathVariable("lastname") String lastname) {
    return service.getCustomerListByAndOperator(firstname, lastname);
  }
}
