package com.sbproject2.sbproject2;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import java.time.LocalDateTime;
import java.util.List;


@SpringBootApplication
public class Sbproject2Application {

    public static void main(String[] args) {
        SpringApplication.run(Sbproject2Application.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
//        return args -> {
//            extracted(studentRepository);
//
//            PageRequest pageRequest = PageRequest.of(0,5,Sort.by("firstName").ascending());
//            Page<Student> page = studentRepository.findAll(pageRequest);
//            System.out.println("Total page: " + page.getTotalPages() + ", elements per page: " + page.getSize() + ", total elements: " + page.getTotalElements());
//            System.out.println(page);
//            System.out.println(page.getContent());
//
//        };
//    }

        @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, StudentIdentityCardRepository StudentIdentityCardRepository){
        return args -> {
            Faker faker = new Faker();

            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = String.format("%s.%s@cdp.com",firstName,lastName);
            int age = faker.number().numberBetween(18,50);
            Student student = new Student(firstName,lastName,email,age);

            student.addBook(new Book(LocalDateTime.now().minusDays(4), "The Alchemist"));
            student.addBook(new Book(LocalDateTime.now().minusDays(4), "The Dodo"));
            student.addBook(new Book(LocalDateTime.now().minusYears(1), "The Machine"));


            StudentIdentityCard studentIdentityCard1 = new StudentIdentityCard("123456789",student);
            StudentIdentityCardRepository.save(studentIdentityCard1);


            studentRepository.findById(1L).ifPresent(s-> {
                System.out.println("fetching books lazy..");
                List<Book> books = s.getBooks();
                books.forEach(book ->
                {
                    System.out.println(s.getFirstName() + " borrowed " + book.getBookName());
                });
            });
//            StudentIdentityCardRepository.findById(1L).ifPresent(System.out::println);
//
//            Optional<Student> optionalStudent = studentRepository.findById(1L);
//            System.out.println(optionalStudent + ", and has a student identity card:" + optionalStudent.get().getStudentIdentityCard().getCardNumber());

            //studentRepository.deleteById(1L); //Nuk fshihet se jena tu try me fshi prej child


        };
    }

    private static void generatingStudentsByNameAscAgeDesc(StudentRepository studentRepository) {
        extracted(studentRepository);

        Sort sort = Sort.by("firstName").ascending().and(Sort.by("age").descending());

        studentRepository.findAll(sort).forEach(student -> System.out.println(student.getFirstName() + " " + student.getAge()));
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
