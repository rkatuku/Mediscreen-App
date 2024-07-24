package com.mediscreen.note.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Note {
    @Id
    private int id;
    private String note;
    private int idPatient;

    public Note() {
    }

    public Note(int idPatient, String note) {
        this.idPatient = idPatient;
        this.note = note;
    }

    public Note(int id, String note, int idPatient) {
        this.id = id;
        this.note = note;
        this.idPatient = idPatient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String notes) {
        this.note = notes;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }
}
