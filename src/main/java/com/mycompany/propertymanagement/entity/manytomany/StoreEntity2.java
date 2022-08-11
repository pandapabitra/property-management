package com.mycompany.propertymanagement.entity.manytomany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StoreEntity2 {

    @Id
    private Long id;
    private String storeName;
    @ManyToMany
    @JoinTable(name = "store_product2",
            joinColumns = {@JoinColumn(name = "fk_store")},
            inverseJoinColumns = {@JoinColumn(name = "fk_product")})
    private Set<ProductEntity2> products = new HashSet<ProductEntity2>();
}
