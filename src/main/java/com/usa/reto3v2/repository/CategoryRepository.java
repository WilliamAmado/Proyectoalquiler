package com.usa.reto3v2.repository;

import com.usa.reto3v2.entities.Admin;
import com.usa.reto3v2.entities.Category;
import com.usa.reto3v2.repository.crudRepository.CategoryCurdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCurdRepository categoryCurdRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCurdRepository.findAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryCurdRepository.findById(id);
    }
    public Category save(Category categoria){
        return categoryCurdRepository.save(categoria);
    }
    public void delete(Category categoria){
        categoryCurdRepository.delete(categoria);
    }
}
