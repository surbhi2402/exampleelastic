package com.ttn.elastic;

import com.ttn.elastic.dao.CustomerRepository;
import com.ttn.elastic.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

  @Autowired
  private CustomerRepository customerRepository;

  @PostMapping("/saveCustomer")
  public int saveCustomer(@RequestBody List<Customer> customers) {
    customerRepository.save(customers);
    return customers.size();
  }

  @GetMapping("/findAll")
  @ResponseBody
  public List<Customer> findAllCustomers() {
    List<Customer> customers = new ArrayList<Customer>();
    Iterable<Customer> customersAll = customerRepository.findAll();
    for (Customer customer : customersAll) {
      customers.add(customer);
    }
    return customers;
  }

  @GetMapping("/findByName/{firstname}")
  public List<Customer> findByFirstName(@PathVariable("firstname") String firstName) {
    return customerRepository.findByFirstname(firstName);
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
