package com.murat.read.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.murat.read.model.CustomerOrder;
import com.murat.read.mongoInterface.CommonRepositoryI;


public interface CustomerOrderRepositoryI extends MongoRepository<CustomerOrder, String>{
	
	List<CustomerOrder> findOrdersByUserId(String userId);
	
}
