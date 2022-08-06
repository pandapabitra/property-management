package com.mycompany.propertymanagement.repository;

import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {

    List<PropertyEntity> findAllByUserEntityId(Long userId);

    //@Query(value = "SELECT p FROM PropertyEntity p WHERE p.userEntity.id = ?1")
    //List<PropertyEntity> findPropertyByUserId(Long userId);
    //@Query(value = "SELECT p FROM PropertyEntity p WHERE p.userEntity.id = :userId")
    //List<PropertyEntity> findPropertyByUserId(@Param("userId") Long userId);
    //@Query(value = "SELECT p FROM PropertyEntity p WHERE p.userEntity.id = :userId and p.title = :title")
    //List<PropertyEntity> findPropertyByUserIdAndTitle(@Param("userId") Long userId, @Param("title") String title);
}
