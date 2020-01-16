package com.repos;

import com.domain.Zayvka;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ZayvkaRepo extends CrudRepository<Zayvka, Long>{

    List<Zayvka> findById(Integer id);
}