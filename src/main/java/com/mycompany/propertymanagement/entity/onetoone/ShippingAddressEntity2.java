package com.mycompany.propertymanagement.entity.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ShippingAddressEntity2 {

    @Id
    private Long id;
    private String address;
    @OneToOne(mappedBy = "shippingAddressEntity2")
    private CustomerEntity2 customerEntity2;
}
