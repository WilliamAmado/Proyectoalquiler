package com.usa.reto3v2.repository.crudRepository;

import com.usa.reto3v2.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CategoryCurdRepository extends CrudRepository<Category, Integer> {
}
