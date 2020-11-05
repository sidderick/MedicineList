package com.nhsbsa.medicinelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    public void updateMedicine(Medicine medicine) {
        medRepository.save(medicine);
    }

    public List<Medicine> listMedicineByName(String medName) {
        return medRepository.findByName(medName);
    }

   public Optional<Medicine> getMedicine(long id) {
        return medRepository.findById(id);
    }


    public void deleteMedicine(long id) {
        medRepository.deleteById(id);
    }


}
