package com.sipl.vehicle_Management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sipl.vehicle_Management.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

}
