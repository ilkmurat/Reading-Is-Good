package com.murat.read.mongoInterface;

import java.util.List;

public interface CommonRepositoryI {

	public <T> List<T> getListById(String id, String searchIdField, Class<T> clazz);

}
