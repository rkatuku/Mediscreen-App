package com.mediscreen.report.entity;

public class Note {
    private int id;
    private String note;
    private int idPatient;

    public Note(int idPatient, String note) {
        this.idPatient = idPatient;
        this.note = note;
    }

    public Note() {
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

    public void setNote(String note) {
        this.note = note;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }
}
