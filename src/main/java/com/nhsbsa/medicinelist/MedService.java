package com.nhsbsa.medicinelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MedService {

    @Autowired
    private MedRepository medRepository;



    final private List<Medicine> med = medicinceutlils.buildMedlist();

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
        if (medRepository.findById(id).isPresent()) {
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
        if (medRepository.findById(id).isPresent()) {
            medRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("id not found");
        }
    }

    public Page<Medicine> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Medicine> list;
        if (Medicine.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, Medicine.size());
        }
        return new PageImpl<>(medRepository.findAll(pageable), PageRequest.of(currentPage, pageSize), Medicine.size());
    }
}