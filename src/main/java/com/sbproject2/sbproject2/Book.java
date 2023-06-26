package com.sbproject2.sbproject2;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Book")
@Table(name = "book")
public class Book {

    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "book_sequence"

    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "created_At",
            nullable = false,
            columnDefinition = "TIMESTAMP WITHOUT TIME ZONE"

    )
    private LocalDateTime localDateTime;

    @Column(
            name = "book_name",
            nullable = false
    )
    private String bookName;

    public Book(LocalDateTime localDateTime, String bookName) {
        this.localDateTime = localDateTime;
        this.bookName = bookName;
    }

    @ManyToOne
    @JoinColumn(
            name = "student_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student_book_fk"
            )
    )
    private Student student;

    public Book() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", localDateTime=" + localDateTime +
                ", bookName='" + bookName + '\'' +
                ", student=" + student +
                '}';
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
