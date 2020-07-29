package com.kodilla.rentacamperbackend.repository;

import com.kodilla.rentacamperbackend.domain.Fine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface FineRepository extends CrudRepository<Fine, Long> {

    @Override
    Fine save(Fine fine);

    @Override
    List<Fine> findAll();

    @Override
    Optional<Fine> findById(Long id);
}
