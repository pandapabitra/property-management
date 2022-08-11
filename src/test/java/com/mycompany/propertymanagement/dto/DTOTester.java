package com.mycompany.propertymanagement.dto;

import com.mycompany.propertymanagement.entity.AddressEntity;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DTOTester {

    @Test
    @DisplayName("Tests all DTO's getter setter")
    void testAllDTOs(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(CalculatorDTO.class);
        beanTester.testBean(PropertyDTO.class);
        beanTester.testBean(UserDTO.class);
        /*beanTester.testBean(AddressEntity.class);
        beanTester.testBean(PropertyEntity.class);
        beanTester.testBean(UserEntity.class);*/
    }
}
