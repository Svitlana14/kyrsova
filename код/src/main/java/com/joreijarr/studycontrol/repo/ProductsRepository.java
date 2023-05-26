package com.joreijarr.studycontrol.repo;

import com.joreijarr.studycontrol.models.Products;
import org.springframework.data.repository.CrudRepository;

public interface ProductsRepository extends CrudRepository<Products, Long> {
}
