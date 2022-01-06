package com.app.ohmybooks.repository;

import com.app.ohmybooks.entity.Author2Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Author2BookRepository extends JpaRepository<Author2Book, Long> {


}
