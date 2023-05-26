package com.joreijarr.studycontrol.repo;

import com.joreijarr.studycontrol.models.Clients;
import org.springframework.data.repository.CrudRepository;

public interface ClientsRepository extends CrudRepository<Clients, Long> {
}
