package com.mycompany.propertymanagement.entity.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductEntity {

    @Id
    private Long id;
    private String productName;
}
