package com.murat.read.mongoInterface;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


public class CommonRepositoryImpl implements CommonRepositoryI {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public CommonRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	  public <T> List<T> getListById(String id, String searchIdField, Class<T> clazz) {

        final Query query = new Query();
        final List<Criteria> criteria = new ArrayList<>();
        if (id != null) {
            criteria.add(Criteria.where(searchIdField).in(id));
        }
        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        }
        return mongoTemplate.find(query, clazz);

    }

}
