package edu.miu.cs.cs425.eregistrar.repository;

import edu.miu.cs.cs425.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;




public interface StudentRepository extends JpaRepository<Student,Integer>  {

    /**
    @Query("SELECT s FROM Student s WHERE s.studentNumber = ?1")
    Optional<Student> findStudentByStudentNumber(String studentNumber);

    @Query("SELECT s FROM Student s WHERE s.firstName = ?1")
    Optional<Student> findStudentByFirstName(String firstName);


    @Query("select s from Student s where s.firstName = :studentName or s.middleName = :studentName or s.lastName = :studentName")
    Optional<Student> findStudentByNameOrLastName(String searchString);

*/

    @Query("select s from Student s where s.firstName = :studentName or s.middleName = :studentName or s.lastName = :studentName")
    Optional<Student> findStudentByFirstOrLastNameOrMiddleName(String studentName);

    List<Student> findStudentsByFirstNameContainingOrLastNameContains(String firstName, String lastName);

//    @Query("SELECT s FROM Student s WHERE s.firstName = ?1", nativeQuery = true
//    Optional<Student> findStudentByFirstName(String firstName);




}
