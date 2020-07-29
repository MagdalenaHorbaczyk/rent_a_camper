package com.kodilla.rentacamperbackend.repository;

import com.kodilla.rentacamperbackend.domain.Camper;
import com.kodilla.rentacamperbackend.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CamperRepository extends CrudRepository<Camper, Long> {

    @Override
    Camper save(Camper camper);

    @Override
    List<Camper> findAll();

    @Override
    Optional<Camper> findById(Long id);

    List<Camper> findAllCampersBySeatsQuantity(int seatsQuantity);

    List<Camper> findAllCampersByDailyRentPrice(BigDecimal dailyRentPrice);

    List<Camper> findAllCampersByCategory(Category category);
}
