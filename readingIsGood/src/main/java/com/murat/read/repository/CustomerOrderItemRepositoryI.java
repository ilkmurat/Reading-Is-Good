package com.murat.read.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.murat.read.model.CustomerOrderItem;

public interface CustomerOrderItemRepositoryI extends MongoRepository<CustomerOrderItem, String> {
	List<CustomerOrderItem> findOrderItemsByUserId(String userId);
}
