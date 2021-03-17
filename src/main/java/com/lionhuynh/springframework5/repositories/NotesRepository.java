package com.lionhuynh.springframework5.repositories;

import com.lionhuynh.springframework5.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes, Long> {
}
