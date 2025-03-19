package com.raxrot;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private List<Student> students=new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(int id) {
       return students.stream()
               .filter(student -> student.getId() == id)
               .findFirst().orElse(null);
    }

    public String [] getStudentsNamesByDepartments(String departments) {
       return students.stream()
                .filter(student -> student.getDepartment()
                        .equals(departments))
                .map(student -> student.getName())
                .toArray(String[]::new);
    }

    public String[] getStudentsIdsByDepartments(String departments) {
        return students.stream()
                .filter(x->x.getName().equals(departments))
                .map(s->s.getId())
                .toArray(String[]::new);
    }

    public Student getStudentByName(String studentName) {
        return students.stream().filter(student -> student.getName().equals(studentName))
                .findFirst().orElseThrow(()->new StudentNotFoundException("Student not found"));
    }
}
