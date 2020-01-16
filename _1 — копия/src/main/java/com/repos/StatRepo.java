package com.repos;

import com.domain.Statuses;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatRepo extends CrudRepository <Statuses, Long> {
    List<Statuses> findById(Integer id);
}
