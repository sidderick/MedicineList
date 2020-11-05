package com.nhsbsa.medicinelist;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface MedRepository extends CrudRepository<Medicine, String> {
    Optional<Medicine> findById(long id);

    List<Medicine> findByName(String name);


    void deleteById(long id);


}
