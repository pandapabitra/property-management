package com.mycompany.propertymanagement.entity.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ProductEntity2 {

    @Id
    private Long id;
    private String productName;
    @ManyToMany(mappedBy = "products")
    private Set<StoreEntity2> stores = new HashSet<StoreEntity2>();
}
