package com.mycompany.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "PROPERTY_TITLE", nullable = false)
    private String title;
    private String description;
    private Double price;
    private String construction;
    private String image1;
    private String image2;
    private String image3;
    private String video;
    private Double area;
    private Integer noOfRooms;
    private Date creationDate;
    private Date updationDate;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID", nullable = false)
    private AddressEntity addressEntity;

    @ManyToOne//(fetch = FetchType.LAZY)//it will not fetch the user data while fetching property
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity userEntity;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private CategoryEntity categoryEntity;
}
