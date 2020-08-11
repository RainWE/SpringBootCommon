package com.allfirst.common.repository;

import com.allfirst.common.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * 测试SpringData ElasticSearch
 * BookRepository继承ElasticsearchRepository的方法，也可以
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
    //Ctrl+F12查看方法或者Ctrl+I或O
    //参照
    // https://docs.spring.io/spring-data/elasticsearch/docs/3.0.6.RELEASE/reference/html/
   public List<Book> findByBookNameLike(String bookName);

}
