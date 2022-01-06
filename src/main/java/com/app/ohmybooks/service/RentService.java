//package com.app.ohmybooks.service;
//
//import com.app.ohmybooks.entity.Rent;
//import com.app.ohmybooks.repository.RentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class RentService {
//
//    @Autowired
//    private RentRepository rentRepository;
//
//    public List<Rent> getAllRentals() {
//        return rentRepository.findAll();
//    }
//
//    public Optional<Rent> getRentalById(Long id) {
//        return rentRepository.findById(id);
//    }
//
//    public Rent saveRent(final Rent rent) {
//        return rentRepository.save(rent);
//    }
//
//    public Optional<Rent> getSpecificRental(Long userId, Long bookId) {
//        return rentRepository.findByUserAndBookId(userId, bookId);
//    }
//}
