package com.kodilla.rentacamperbackend.repository;

import com.kodilla.rentacamperbackend.domain.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface BookingRepository extends CrudRepository<Booking, Long> {

    @Override
    Booking save(Booking booking);

    @Override
    List<Booking> findAll();

    @Override
    Optional<Booking> findById(Long id);
}
