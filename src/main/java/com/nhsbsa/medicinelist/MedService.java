package com.nhsbsa.medicinelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<Medicine> listMedicineByName(String medName) {
        return medRepository.findByName(medName);
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
