package com.sbproject2.sbproject2;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "StudentIdentityCard")
@Table(name = "student_identity_card", uniqueConstraints = { @UniqueConstraint(
        name = "student_identity_card_number_unique",
        columnNames = "card_number"
)})
public class StudentIdentityCard {
    @Id
    @SequenceGenerator(
            name = "student_identity_card_sequence",
            sequenceName = "student_identity_card_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy =SEQUENCE,
            generator = "student_identity_card_sequence"

    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "card_number",
            nullable = false,
            length =15
    )
    private String cardNumber;


    public StudentIdentityCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch= FetchType.EAGER
    )
    @JoinColumn(
            name = "student_id",
            referencedColumnName="id",
            foreignKey = @ForeignKey(
                    name = "student_identity_card_student_id_fk"
            )
    )
    private Student student;


    @Override
    public String toString() {
        return "StudentIdentityCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", student=" + student +
                '}';
    }

    public StudentIdentityCard(String cardNumber){
        this.cardNumber = cardNumber;
    }

    public StudentIdentityCard(){

    }

}
