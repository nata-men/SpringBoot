package com.repos;

import com.domain.AdminAuto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRepo extends CrudRepository<AdminAuto,Long> {
    List<AdminAuto> findByLogin (String login);
}
