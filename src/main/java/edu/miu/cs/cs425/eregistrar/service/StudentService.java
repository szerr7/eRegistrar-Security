package edu.miu.cs.cs425.eregistrar.service;



import edu.miu.cs.cs425.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student newStudent);
    List<Student> getAllStudents();
    void deleteStudentById(Integer studentID);

    Student findStudentById(Integer studentId);

    Student updatedStudent(Student student) ;

    List<Student> searchStudent(String searchString) ;
    }

