package com.devau.travel.dao;

import com.devau.travel.entity.Traveller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TravellerRepository extends JpaRepository<Traveller, Integer> {


    @Query("select a from Traveller a where a.startDate BETWEEN :startDate and :endDate")
    List<Traveller> betweenDates(@Param("startDate") String startDate,
                                                      @Param("endDate") String endDate);

}
