package edu.miu.cs.cs425.eregistrar.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId ;


    private String studentNumber ;


    private String firstName ;

    private String middleName ;


    private String lastName ;

    private float cgpa ;

    @DateTimeFormat(pattern = "yyyy-M-dd")
    private LocalDate enrollmentDate ;


    //private boolean isInternational ;


    private String isInternational ;


}
