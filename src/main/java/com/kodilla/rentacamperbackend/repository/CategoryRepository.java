package com.kodilla.rentacamperbackend.repository;

import com.kodilla.rentacamperbackend.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Override
    Category save(Category category);

    @Override
    List<Category> findAll();

    @Override
    Optional<Category> findById(Long id);
}
