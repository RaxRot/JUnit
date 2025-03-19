package com.raxrot;

public class StudentNotFoundException extends  RuntimeException{
    public StudentNotFoundException(String message) {
        super(message);
    }
}
