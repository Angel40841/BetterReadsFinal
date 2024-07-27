package com.example.betterreads.repositories;

import com.example.betterreads.model.entites.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
    Long findOneById(Long currentUserLogin);
}
