package edu.tcu.cs.superfrogschedulerbackend.student;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String id){super("Could not find student with Id: " + id);}
}
