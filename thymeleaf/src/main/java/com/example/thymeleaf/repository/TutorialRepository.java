package com.example.thymeleaf.repository;

import com.example.thymeleaf.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {
    List<Tutorial> findByTitleContainingIgnoreCase(String keyword);

    @Query("UPDATE Tutorial t SET t.published = :published WHERE t.id = :id")
    @Modifying
    void updatePublishedStatus(Integer id, boolean published);
}