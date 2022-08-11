package com.mycompany.propertymanagement.entity.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShippingAddressEntity {

    @Id
    private Long id;
    private String address;
}
