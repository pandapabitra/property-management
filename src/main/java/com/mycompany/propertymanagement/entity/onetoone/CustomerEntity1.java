package com.mycompany.propertymanagement.entity.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CustomerEntity1 {

    @Id
    private Long id;
    private String customerName;
    @OneToOne
    @JoinColumn(name = "fk_shippingaddress")
    private ShippingAddressEntity1 shippingAddressEntity1;
}
