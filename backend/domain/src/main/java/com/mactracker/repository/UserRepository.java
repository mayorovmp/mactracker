package com.mactracker.repository;

import com.mactracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select e from User e " +
            "left join fetch e.authorities " +
            "where e.email = :email and e.password = :pass")
    Optional<User> findByEmailAndPass(@Param("email")String email, @Param("pass")String pass);
    Optional<User> findByEmail(String email);
}
