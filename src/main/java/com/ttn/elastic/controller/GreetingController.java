package com.ttn.elastic.controller;

import com.ttn.elastic.entity.Greeting;
import com.ttn.elastic.service.GreetingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingController {

  @Autowired
  private GreetingService greetingService;

  @ResponseBody
  @RequestMapping(value = "/greetings", method = RequestMethod.GET)
  public ResponseEntity<List<Greeting>> getAll() {
    return new ResponseEntity<List<Greeting>>(greetingService.getAll(), HttpStatus.OK);
  }

  @ResponseBody
  @RequestMapping(value = "/greetings", method = RequestMethod.POST)
  public ResponseEntity<Greeting> insertGreeting(@RequestBody Greeting greeting) {
    return new ResponseEntity<Greeting>(greetingService.create(greeting), HttpStatus.CREATED);
  }

  @ResponseBody
  @RequestMapping(value = "/greetings", method = RequestMethod.PUT)
  public ResponseEntity<Greeting> updateGreeting(@RequestBody Greeting greeting) {
    return new ResponseEntity<Greeting>(greetingService.update(greeting), HttpStatus.MOVED_PERMANENTLY);
  }

  @ResponseBody
  @RequestMapping(value = "/greetings/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Greeting> deleteGreeting(@PathVariable("id") String idd) {
    greetingService.delete(idd);
    return new ResponseEntity<Greeting>(HttpStatus.NO_CONTENT);
  }

  @ResponseBody
  @RequestMapping(value = "/greetings{id}", method = RequestMethod.POST)
  public ResponseEntity<Greeting> getOne(@PathVariable("id") String idd) {
    return new ResponseEntity<Greeting>(greetingService.findOne(idd), HttpStatus.OK);
  }

  @ResponseBody
  @RequestMapping(value = "/greetings/{name}", method = RequestMethod.GET)
  public ResponseEntity<List<Greeting>> getByUserName(@PathVariable("name") String name) {
    return new ResponseEntity<List<Greeting>>(greetingService.getGreetingByUsername(name), HttpStatus.OK);
  }
}
