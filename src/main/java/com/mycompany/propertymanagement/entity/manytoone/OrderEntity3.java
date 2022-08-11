package com.mycompany.propertymanagement.entity.manytoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderEntity3 {

    @Id
    private Long id;
    @OneToMany(mappedBy = "orderItemEntity3")
    private List<OrderItemEntity3> orderItemEntity3List = new ArrayList<OrderItemEntity3>();
}
