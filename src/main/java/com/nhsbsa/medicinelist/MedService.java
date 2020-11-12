package com.nhsbsa.medicinelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MedService {

    @Autowired
    private MedRepository medRepository;


    public List<Medicine> getAllMeds() {

        List<Medicine> medicine = new ArrayList<>();

        medRepository.findAll()
                .forEach(medicine::add);
        return medicine;
    }

    public void addMedicine(Medicine medicine) {
        medRepository.save(medicine);
    }


    public void updateMedicine(long id, Medicine medicine) {
        if (medRepository.findById(id) != null) {
            medRepository.save(medicine);
        } else {
            throw new EntityNotFoundException("id not found");
        }
    }

    public List<Medicine> listMedicineByName(String name) {
        if (medRepository.findByName(name) != null) {
            return medRepository.findByName(name);
        } else {
            throw new EntityNotFoundException("id not found");
        }
    }

    public void deleteMedicine(long id) {
        if (medRepository.findById(id) != null) {
            medRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("id not found");
        }
    }
}

