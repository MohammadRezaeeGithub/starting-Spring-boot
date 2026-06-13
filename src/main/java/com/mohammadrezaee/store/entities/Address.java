package com.mohammadrezaee.store.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "zip")
    private String zip;

//    @Column(name = "user_id")
//    private String user_id;

    @Column(name = "state")
    private String state;

    //to define a BI directional relationship
    //the owner of this relationship is Address because it knows about user witt user_id column but user does not anything about address
    //we need to tell hibernate about it in User
    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude // to avoid making a loup when it change the object to String
    private User user;
}
