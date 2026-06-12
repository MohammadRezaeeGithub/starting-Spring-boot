package com.mohammadrezaee.store.entities;

import jakarta.persistence.*;
import lombok.*;

//using Lambok helps us to uses its Getters and Setters with this annotation instead of writing them
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users") // because the hibernate expect the table with name User, we need this changes
public class User {

//    the generationValue annotation says how to ids are generated
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    //when the name of the field here and in the database is different we use the Column annotation
    //by convention Hibernate expect the column with this name. but sometimes we need to change it
    //so we use it to tell what is the name in the database
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

}
