package com.murat.read.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.murat.read.model.Book;
import com.murat.read.mongoInterface.CommonRepositoryI;


public interface BookRepositoryI extends MongoRepository<Book, String> {

}
