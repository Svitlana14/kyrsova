package com.joreijarr.studycontrol.repo;

import com.joreijarr.studycontrol.models.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {
}
