package com.mediscreen.report.repository;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mediscreen.report.entity.Note;

import java.util.List;

@FeignClient(name = "microservice-note")
@RibbonClient(name = "microservice-note")
public interface NoteRepository {

    @GetMapping("/patHistory/patient/{id}")
    List<Note> findNoteByPatient(@PathVariable int id);
}
