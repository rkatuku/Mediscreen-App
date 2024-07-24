package com.mediscreen.note.repository;

import com.mediscreen.note.entity.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository  extends MongoRepository<Note, Integer> {
	@SuppressWarnings("unchecked")
    Note save(Note note);
    Note findById(int id);
    void delete(Note note); 
    @SuppressWarnings({ "unchecked", "rawtypes" })
    List findAll();
    Note findTopByOrderByIdDesc();       
    @SuppressWarnings("rawtypes")
	List findByIdPatient(int id);
}
