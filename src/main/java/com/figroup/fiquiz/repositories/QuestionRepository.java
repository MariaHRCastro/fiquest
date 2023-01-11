package com.figroup.fiquiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.figroup.fiquiz.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

}
