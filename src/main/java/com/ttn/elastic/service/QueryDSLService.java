package com.ttn.elastic.service;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

import com.ttn.elastic.entity.Customer;
import java.util.List;
import org.elasticsearch.index.query.MultiMatchQueryBuilder.Type;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

@Service
public class QueryDSLService {

  @Autowired
  private ElasticsearchTemplate template;

  public List<Customer> searchByMultiFields(String firstName, int age) {
    QueryBuilder query = QueryBuilders.boolQuery()
        .must(matchQuery("firstname", firstName))
        .must(matchQuery("age", age));
    NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
    return template.queryForList(nativeSearchQuery, Customer.class);
  }

  public List<Customer> getCustomerSearchData(String input) {
    String searchString = ".*" + input + ".*";
    QueryBuilder query = QueryBuilders.boolQuery()
        .must(QueryBuilders.regexpQuery("firstname", searchString));
    NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
    return template.queryForList(nativeSearchQuery, Customer.class);
  }

  public List<Customer> multiMatchQuery(String text) {
    SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.multiMatchQuery(text)
    .field("firstname").field("lastname").type(Type.BEST_FIELDS)).build();
    return template.queryForList(searchQuery, Customer.class);
  }

  public List<Customer> getCustomerListByAndOperator(String firstname, String lastname) {
    QueryBuilder query = QueryBuilders
        .boolQuery()
        .must(matchQuery("age", 30))
        .should(matchQuery("firstname", firstname))
        .should(matchQuery("lastname", lastname))
        .minimumNumberShouldMatch(2);
    NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
    return template.queryForList(nativeSearchQuery, Customer.class);
  }
}
