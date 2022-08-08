package com.mycompany.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER_ENTITY")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(name = "EMAIL", nullable = false)
    private String email;
    private String phone;
    @Column(nullable = false)
    private String password;
    private Date creationDate;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID")
    private AddressEntity addressEntity;
}
