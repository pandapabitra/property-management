package com.mycompany.propertymanagement.entity.manytoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderEntity1 {

    @Id
    private Long id;
    @OneToMany
    private List<OrderItemEntity1> orderItemEntity1List = new ArrayList<OrderItemEntity1>();
}
