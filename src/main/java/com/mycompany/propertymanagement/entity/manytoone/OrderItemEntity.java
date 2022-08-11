package com.mycompany.propertymanagement.entity.manytoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItemEntity {

    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_name")
    private OrderEntity orderEntity;
}
