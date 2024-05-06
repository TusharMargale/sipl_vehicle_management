package com.sipl.vehicle_Management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sipl.vehicle_Management.entity.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long>{

}
