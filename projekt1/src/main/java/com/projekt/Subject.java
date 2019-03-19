package com.projekt;

public class Subject {

   private String note;
   private String name;


    private String semester;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Subject(String note, String name, String semester) {
        this.note = note;
        this.name = name;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return semester + "\t" + name + "\t\t" + note;
    }
}
