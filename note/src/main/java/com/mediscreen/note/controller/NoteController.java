package com.mediscreen.note.controller;

import com.mediscreen.note.entity.Note;
import com.mediscreen.note.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/patHistory")
public class NoteController {
	@Autowired
	NoteService noteManager;

	@GetMapping
	public List<Note> findAll() {
		return noteManager.list();
	}

	@GetMapping("/{id}")
	public Note findPatient(@PathVariable int id) {
		return noteManager.find(id);
	}

	@GetMapping("/patient/{id}")
	public List<Note> findNoteByPatient(@PathVariable int id) {
		return noteManager.listByPatient(id);
	}

	@PostMapping
	public Note create(@RequestBody Note note) {
		return noteManager.save(note);
	}

	@PostMapping("/add")
	public Note create(@RequestParam int patId, @RequestParam String note) {
		return noteManager.save(new Note(patId, note));
	}

	@PutMapping
	public Note update(@RequestBody Note note) {
		return noteManager.save(note);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		noteManager.delete(id);
	}
}
