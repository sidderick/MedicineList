package com.nhsbsa.medicinelist;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MedRepository extends CrudRepository<Medicines, String> {
    Optional<Medicines> findById(long id);

    void deleteById(long id);
}
