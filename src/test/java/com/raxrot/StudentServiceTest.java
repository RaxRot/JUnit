package com.raxrot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    public void getStudentsTestAssertTrue(){
        StudentService studentService = new StudentService();
        List<Student> listOfStudents = studentService.getStudents();
        boolean actualResult=listOfStudents.isEmpty();

        assertTrue(actualResult,"List is empty");
    }

    @Test
    public void getStudentsTestAssertFalse(){
        StudentService studentService = new StudentService();
        Student student=new Student(1,"Vlad","D");
        studentService.addStudent(student);
        List<Student> listOfStudents = studentService.getStudents();
        boolean actualResult=listOfStudents.isEmpty();

        assertFalse(actualResult,"List is empty");
    }

    @Test
    public void getStudentByIdTestAssertNull(){
        StudentService studentService = new StudentService();
        Student getStudentById=studentService.getStudentById(10);
        assertNull(getStudentById,"getStudentById is null");
    }

    @Test
    public void getStudentByIdTestAssertNotNull(){
        StudentService studentService = new StudentService();
        Student student=new Student(1,"Vlad","D");
        studentService.addStudent(student);
        Student getStudentById=studentService.getStudentById(1);
        assertNotNull(getStudentById,"getStudentById is null");
    }

    @Test
    public void getStudentByIdTestAssertAssertEquals(){
        StudentService studentService = new StudentService();
        Student student=new Student(1,"Vlad","D");
        studentService.addStudent(student);
        Student getStudentById=studentService.getStudentById(1);

        assertEquals(student.getId(),getStudentById.getId(),"not equal");
        assertEquals("Vlad",getStudentById.getName(),"not equal");

        assertEquals(student,getStudentById,"not equal");
    }

    @Test
    public void getStudentByIdTestAssertAssertNotEquals(){
        StudentService studentService = new StudentService();
        Student student=new Student(1,"Vlad","D");
        Student student1=new Student(2,"Roma","D");
        studentService.addStudent(student);
        Student getStudentById=studentService.getStudentById(1);

        assertNotEquals(5,getStudentById.getId()," equal");
        assertNotEquals("Vlados",getStudentById.getName(),"equal");
        assertNotEquals(student,student1,"equal");
    }

    @Test
    public void getStudentNamesByDepartmentTestArrayEqual(){
        StudentService studentService = new StudentService();
        Student student=new Student(1,"Vlad","D");
        Student student1=new Student(2,"Roma","D");
        Student student2=new Student(3,"Vlad","V");
        studentService.addStudent(student);
        studentService.addStudent(student1);
        studentService.addStudent(student2);

        String[]actualArray=studentService.getStudentsNamesByDepartments("D");
        String[] expectedArray={"Vlad","Roma"};
        assertArrayEquals(expectedArray,actualArray);
    }

    @Test
    public void getStudentsListAssertIterableEquals(){
        List<Student>list1= Arrays.asList(new Student(1,"Vlad","D"),new Student(2,"Roma","D"));
        List<Student>list2= Arrays.asList(new Student(1,"Vlad","D"),new Student(2,"Roma","D"));

        assertIterableEquals(list1,list2,"not equals");
    }

   @Test
    public void testDevideZero(){
        assertThrows(ArithmeticException.class,()->{
            int divide=1/0;
        },"should throw ArithmeticException");
   }

   @Test
    public void testAssetThrowsException(){
       StudentService studentService = new StudentService();
        assertThrows(RuntimeException.class,()->{
            studentService.getStudentByName("Vlad");
        },"should throw RuntimeException");
   }

    @Test
    public void testAssetThrowsExactlyException(){
        StudentService studentService = new StudentService();
        assertThrowsExactly(StudentNotFoundException.class,()->{
            studentService.getStudentByName("Vlad");
        },"should throw StudentNotFoundException");
    }

    @Test
    public void testAssetAll(){
        assertAll(
                ()->assertEquals(3,3,"not equal"),
                ()->assertTrue(5>0,"error"),
                ()->assertNull(null,"error")
        );
    }
}