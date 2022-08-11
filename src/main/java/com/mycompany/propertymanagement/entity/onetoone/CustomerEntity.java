package com.mycompany.propertymanagement.entity.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CustomerEntity {

    @Id
    private Long id;
    private String customerName;
    @OneToOne
    private ShippingAddressEntity shippingAddressEntity;
}
