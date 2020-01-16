package com.repos;

import com.domain.TipGruz;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TipRepo extends CrudRepository<TipGruz, Long> {
    List<TipGruz> findById(Integer id);
}
