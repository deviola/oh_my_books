package com.app.ohmybooks.repository;

import com.app.ohmybooks.entity.auth.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    Optional<Login> findByLogin(String login);

}
