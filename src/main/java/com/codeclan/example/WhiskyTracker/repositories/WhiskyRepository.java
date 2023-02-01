package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskyByYear(Integer year);
    List<Whisky> findWhiskyByAge(Integer age);
    List<Whisky> findWhiskyByAgeAndDistilleryName(Integer age, String name);
    List<Whisky> findWhiskyByAgeAndYear(Integer age, Integer year);
    List<Whisky> findWhiskyByDistilleryRegion(String region);

}
