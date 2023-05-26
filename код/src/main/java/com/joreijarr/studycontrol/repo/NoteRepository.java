package com.joreijarr.studycontrol.repo;

import com.joreijarr.studycontrol.models.Notes;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Notes, Long> {
}
