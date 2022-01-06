package com.app.ohmybooks.repository;

import com.app.ohmybooks.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a " +
            "WHERE a.firstName = :firstName AND " +
            "a.lastName = :lastName ")
    Author findByName(@Param("firstName") String firstName,
                      @Param("lastName") String lastName);
}
