package com.projekt;

public class Subject {

   private float note;
   private String name;
   private int semester;

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Subject(float note, String name, int semester) {
        this.note = note;
        this.name = name;
        this.semester = semester;
    }
}
