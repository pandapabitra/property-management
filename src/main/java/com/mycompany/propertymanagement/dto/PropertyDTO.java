package com.mycompany.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PropertyDTO {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private String construction;
    private String image1;
    private String image2;
    private String image3;
    private String video;
    private Double area;
    private Integer noOfRooms;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date creationDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date updationDate;
    private Long userId;
    private Long categoryId;

    private AddressDTO addressDTO;
}
