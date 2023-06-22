package com.sbproject2.sbproject2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Sbproject2Application {

    public static void main(String[] args) {
        SpringApplication.run(Sbproject2Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
          Student john = new Student(
                  "John","Doe","john@doe.com",21
          );
          Student jane = new Student("Jane","Doe","jane@doe.com",22);
            System.out.println("Adding jane and jon to the database");

            Student travolta = new Student(
                    "John", "Travolta","john@travolta.com",25
            );
          studentRepository.saveAll(List.of(john,jane,travolta));

            System.out.println("fetching a student by email");
            studentRepository.findStudentByEmail("john@doe.com").ifPresentOrElse(
                    student -> System.out.println("found " + student), () -> System.out.println("not foouund")
            );

            System.out.println("fetching students by first name and age");
            studentRepository.findStudentsByFirstNameEqualsAndAgeEquals("John",21).forEach(System.out::println);

            studentRepository.findStudentsByFirstNameEqualsAndAgeGreaterThan("John",21).forEach(System.out::println);
//            System.out.println("checking the amount of students in the db");
//            System.out.println("we have "+ studentRepository.count() + " students in the db");
//
//            System.out.println("Checking for student with id 2 in the db");
//            studentRepository.findById(2L).ifPresentOrElse(student -> {
//                System.out.println("we found " + student + " in the db");
//            }, () -> {
//                System.out.println("we did not find a student with that id");
//            });
//
//            System.out.println("Checking for student with id 3 in the db");
//            studentRepository.findById(3L).ifPresentOrElse(student -> {
//                System.out.println("we found " + student + " in the db");
//            }, () -> {
//                System.out.println("we did not find a student with that id");
//            });
//
//            System.out.println("fetching all students from the database");
//            List<Student>students = studentRepository.findAll();
//            students.forEach(System.out::println);
//
//            System.out.println("Deleting student with id 2");
//
//            studentRepository.deleteById(2L);
//
//            System.out.println("check the amount of students in the db, after deleting student with id 2");
//            System.out.println("we have "+ studentRepository.count() + " student in the db.");

        };
    }
}
