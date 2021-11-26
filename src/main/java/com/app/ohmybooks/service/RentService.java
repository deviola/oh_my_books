package com.app.ohmybooks.service;

import com.app.ohmybooks.entity.Rent;
import com.app.ohmybooks.repository.RentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentService {

    @Autowired
    private RentRepo rentRepo;

    public List<Rent> getAllRentals() {
        return rentRepo.findAll();
    }

    public Optional<Rent> getRentalById(Long id) {
        return rentRepo.findById(id);
    }

    public Rent saveRent(final Rent rent) {
        return rentRepo.save(rent);
    }

    public Optional<Rent> getSpecificRental(Long userId, Long bookId) {
        return rentRepo.findByUserAndBookId(userId, bookId);
    }
}
