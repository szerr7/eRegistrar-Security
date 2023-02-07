package edu.miu.cs.cs425.eregistrar.service.impl;


import edu.miu.cs.cs425.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @Override
    public List<Student> getAllStudents() {


        List<Student> student = studentRepository.findAll().stream().sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName()))
                .toList();
        return student;
    }

    @Override
    public void deleteStudentById(Integer studentID) {

        studentRepository.deleteById(studentID);
    }

    @Override
    public Student findStudentById(Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public Student updatedStudent(Student student) {
//        Student student = studentRepository.findById(id).orElse(null);

//        if (student ==null) throw new NullPointerException("No such Student");
//        student.setFirstName(student.getFirstName());
//        student.setLastName(student.getLastName());
//        student.setStudentNumber(student.getStudentNumber());
//        student.setEnrollmentDate(student.getEnrollmentDate());
//        student.setMiddleName(student.getMiddleName());
//        student.setCgpa(student.getCgpa());
//        //.isInternational(studentRes.isInternational());


//        Student newStudent = new Student(null, student.getStudentNumber(),
//                student.getFirstName(), student.getMiddleName(),
//                student.getLastName(), student.getCgpa(),
//                student.getEnrollmentDate(), student.getIsInternational());


        return studentRepository.save(student);
    }



    @Override
    public List<Student> searchStudent(String searchString) {
        return  studentRepository.findStudentsByFirstNameContainingOrLastNameContains(searchString, searchString);
    }


//    @Override
//    public List<Student> searchStudents(String searchString) {
//        return studentRepository.findAllByStudentNumberContainingOrFirstNameContainingOrMiddleNameContainingOrLastNameContainingOrCgpaContainingOrEnrollmentDateContainingOrIsInternationalContaining(searchString, searchString, searchString, searchString, searchString, searchString, searchString);
//
//    }


//    public Student updatedStudent(Integer studentId) {
//        var student = studentRepository.findById(studentId).orElse(null);
//        return studentRepository.save(student);
//    }



}
