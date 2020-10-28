package com.nhsbsa.medicinelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedService {

    @Autowired
    private MedRepository medRepository;


    public List<Medicines> getAllMeds() {

        List<Medicines> medicines = new ArrayList<>();

        medRepository.findAll()
                .forEach(medicines::add);
        return medicines;
    }

    public void addMedicine(Medicines medicine) {
        medRepository.save(medicine);
    }

 /*   public Optional<Medicines> getMedicine(long id) {
        return medRepository.findById(id);
    }

    public void updateMedicine(long id, Medicines medicine) {
        medRepository.save(medicine);
    }

    public void deleteMedicine(long id) {
        medRepository.deleteById(id);
    }*/


}
