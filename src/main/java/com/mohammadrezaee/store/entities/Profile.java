package com.mohammadrezaee.store.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "bio")
    private String bio;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "loyalty_points")
    private Integer loyaltyPoints;

    //defining one to one relationship with user
    //since the profile knows about user(forign key) and user does not know anything about profile -> profile is the owner of the relationship
    @JoinColumn(name = "id")
    @OneToOne
    @MapsId //this is only for one to one relationship and we have to add it to the owner of the relationship
    @ToString.Exclude
    private User user;

}
