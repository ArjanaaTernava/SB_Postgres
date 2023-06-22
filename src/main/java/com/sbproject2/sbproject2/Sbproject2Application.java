package com.sbproject2.sbproject2;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootApplication
public class Sbproject2Application {

    public static void main(String[] args) {
        SpringApplication.run(Sbproject2Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            extracted(studentRepository);

            Sort sort = Sort.by("firstName").ascending().and(Sort.by("age").descending());

            studentRepository.findAll(sort).forEach(student -> System.out.println(student.getFirstName() + " " + student.getAge()));

        };
    }

    private static void extracted(StudentRepository studentRepository) {
        Faker faker = new Faker();

        for (int i =0; i < 20 ; i++){
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@cdp.com",firstName,lastName);
            int age = faker.number().numberBetween(18,50);
            Student student = new Student(firstName,lastName,email,age);
            studentRepository.save(student);
        }
    }
}
