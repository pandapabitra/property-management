package com.mycompany.propertymanagement.entity.manytoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderEntity2 {

    @Id
    private Long id;
    @OneToMany
    @JoinColumn(name = "fk_order")
    private List<OrderItemEntity2> orderItemEntity2List = new ArrayList<OrderItemEntity2>();
}
