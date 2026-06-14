package com.mohammadrezaee.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//using Lambok helps us to uses its Getters and Setters with this annotation instead of writing them
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString //when we print this entity on terminal
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

    //defining a one to many relationship between user and addresses
    //to define a relationship we annotated it with
    //the relationship can be UNI(one sided) or BI(two sided) directional
    //the mappedby telling Hibernate who is the owner of this relationship
    //adding Builder.default makes it build becaus in builder pattern it gets skipped (this kind of definition)
    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Address> addresses = new ArrayList<>();

    //each time we want to add data, we have to write this two lines which are necessary, so we define this method to make the life easier
    public void addAddress(Address address)
    {
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address){
        addresses.remove(address);
        address.setUser(null);
    }

    //MANY TO MANY RELATIONSHIP
    //first we define a SET(because we can not have a douplicate, this is the difference bwtween SET and List)
    //in this relationship, we make uset the owner of the relationship
    //in the other class we set @ManyToMany(mappedBy = "tags")
    @ManyToMany
    @JoinTable(
            name = "user_tags",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Builder.Default
    private Set<Tag> tags = new HashSet<>();

    //we pass a string and make this method responsible for making tag
    public void addTag(String tagName){
        var tag = new Tag(tagName);

        tags.add(tag);
        tag.getUsers().add(this );
    }

    //defining one to one relationship
    //since we make the profile the owner of this relationship, we have to add mappedBy="user" here
    @OneToOne(mappedBy = "user")
    private Profile profile;
}
