package com.mycompany.propertymanagement.exceptionold;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class BusinessException extends RuntimeException {

    private List<ErrorModel> errors;

    public BusinessException(List<ErrorModel> errors) {
        this.errors = errors;
    }
}
