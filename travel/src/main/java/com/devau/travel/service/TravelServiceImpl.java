package com.devau.travel.service;

import com.devau.travel.dao.TravellerRepository;
import com.devau.travel.entity.Traveller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TravelServiceImpl implements TravelService {
    private final TravellerRepository travellerRepository;

    @Autowired
    public TravelServiceImpl(TravellerRepository travellerRepository) {
        this.travellerRepository = travellerRepository;
    }


    @Override
    public List<Traveller> findAll() {
        return (List<Traveller>) travellerRepository.findAll();

    }

    @Override
    public Traveller findById(int theId) {
        Optional<Traveller> result = travellerRepository.findById(theId);
        Traveller theTraveller = null;

        if (result.isPresent()) {
            theTraveller = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theTraveller;
    }

    @Override
    public void save(Traveller traveller) {
        travellerRepository.save(traveller);

    }

    @Override
    public void deleteById(int theId) {
        travellerRepository.deleteById(theId);

    }

    @Override
    public List<Traveller>  findByDate(String d1, String d2) {
        return travellerRepository.betweenDates(d1, d2);
    }


}
