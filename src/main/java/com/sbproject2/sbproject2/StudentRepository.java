package com.sbproject2.sbproject2;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Long> {

    @Query("SELECT s FROM Student s where s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
    @Query("SELECT s FROM Student s WHERE s.firstName = ?1 and s.age=?2")
    List<Student> findStudentsByFirstNameEqualsAndAgeEquals(String firstName, Integer age);

    @Query("SELECT s FROM Student s WHERE s.firstName=:firstName and s.age > :age")
    List<Student>findStudentsByFirstNameEqualsAndAgeGreaterThan(@Param("firstName") String firstName,@Param("age") Integer age);

    @Query(value = "SELECT * FROM student WHERE first_name = :firstName AND age= :age", nativeQuery = true)
    List<Student> findStudentsByFirstNameEqualsAndAgeEqualsNative(@Param("firstName") String firstName,@Param("age") Integer age);

    @Modifying
    @Transactional
    @Query("DELETE Student u where u.id = ?1")
    int deleteStudentById(Long id);

}
