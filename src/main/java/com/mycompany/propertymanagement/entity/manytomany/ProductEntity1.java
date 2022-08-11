package com.mycompany.propertymanagement.entity.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductEntity1 {

    @Id
    private Long id;
    private String productName;
}
