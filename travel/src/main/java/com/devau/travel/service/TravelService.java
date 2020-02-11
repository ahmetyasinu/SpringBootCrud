package com.devau.travel.service;

import com.devau.travel.entity.Traveller;

import java.util.Date;
import java.util.List;

public interface TravelService {

    public List<Traveller> findAll();
    public Traveller findById(int id);
    public void save(Traveller traveller);
    public void deleteById(int id);
     List<Traveller> findByDate(String d1,String d2);
}
