package com.app.ohmybooks.repository;

import com.app.ohmybooks.domain.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface RentRepo extends CrudRepository<Rent, Long> {

    @Override
    List<Rent> findAll();

    @Override
    Rent save(Rent rent);

    @Override
    Optional<Rent> findById(Long id);

    @Override
    void deleteById(Long id);

    Optional<Rent> findByUserAndBookId(Long userId, Long bookId);
}
