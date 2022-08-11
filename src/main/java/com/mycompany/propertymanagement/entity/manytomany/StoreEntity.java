package com.mycompany.propertymanagement.entity.manytomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StoreEntity {

    @Id
    private Long id;
    private String storeName;
    @ManyToMany
    private Set<ProductEntity> products = new HashSet<ProductEntity>(   );
}
