package com.app.ohmybooks.repository;

import com.app.ohmybooks.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BookRepo extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll();

    @Override
    Book save(Book book);

    @Override
    Optional<Book> findById(Long id);

    @Override
    void deleteById(Long id);
}
