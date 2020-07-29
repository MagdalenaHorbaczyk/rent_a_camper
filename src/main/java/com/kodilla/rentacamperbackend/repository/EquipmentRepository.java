package com.kodilla.rentacamperbackend.repository;

import com.kodilla.rentacamperbackend.domain.Equipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface EquipmentRepository extends CrudRepository<Equipment, Long> {

    @Override
    Equipment save(Equipment equipment);

    @Override
    List<Equipment> findAll();

    @Override
    Optional<Equipment> findById(Long id);
}
