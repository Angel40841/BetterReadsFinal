package com.example.betterreads.repositories;

import com.example.betterreads.model.entites.UserBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBooksRepository extends JpaRepository<UserBooks, Long> {
}
