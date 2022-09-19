package com.excercise.lesson2.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_gen", initialValue = 101, allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "isim", length = 300)
    private String firstName;
    @Column(name = "soyad", length = 300)
    private String lastName;
}
