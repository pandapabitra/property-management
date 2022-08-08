package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.AddressEntity;
import com.mycompany.propertymanagement.entity.CategoryEntity;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import com.mycompany.propertymanagement.repository.AddressRepository;
import com.mycompany.propertymanagement.repository.CategoryRepository;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Value("${pms.dummy:}")
    private String dummy;

    @Value("${spring.datasource.url:}")
    private String dbUrl;

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        Optional<UserEntity> optUe = userRepository.findById(propertyDTO.getUserId());
        if(optUe.isPresent()) {
            //PropertyEntity pe = propertyConverter.convertDTOToEntity(propertyDTO);
            PropertyEntity pe = new PropertyEntity();
            BeanUtils.copyProperties(propertyDTO, pe);
            pe.setUserEntity(optUe.get());
            //get the category instance from the DB
            CategoryEntity ce = categoryRepository.findById(propertyDTO.getCategoryId()).get();
            pe.setCategoryEntity(ce);
            pe.setCreationDate(new Date());

            AddressEntity ae = new AddressEntity();
            BeanUtils.copyProperties(propertyDTO.getAddressDTO(), ae);
            ae = addressRepository.save(ae);

            pe.setAddressEntity(ae);

            pe = propertyRepository.save(pe);

            //propertyDTO = propertyConverter.convertEntityToDTO(pe);
            BeanUtils.copyProperties(pe, propertyDTO);
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("USER_ID_NOT_EXISTS");
            errorModel.setMessage("User does not exists");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);
        }
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {

        //System.out.println("Inside service "+dummy);
        //System.out.println("Inside service "+dbUrl);
        List<PropertyEntity> listOfProps = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();

        for(PropertyEntity pe: listOfProps) {
            PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
            propList.add(dto);
        }
        return propList;
    }

    @Override
    public List<PropertyDTO> getAllPropertiesForUser(Long userId) {

        List<PropertyEntity> listOfProps = propertyRepository.findAllByUserEntityId(userId);
        //List<PropertyEntity> listOfProps = propertyRepository.findPropertyByUserId(userId);
        List<PropertyDTO> propList = new ArrayList<>();

        for (PropertyEntity pe: listOfProps) {
            PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
            propList.add(dto);
        }
        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()) {
            PropertyEntity pe = optEn.get();//data fom database
            pe.setTitle(propertyDTO.getTitle());
            //pe.setAddress(propertyDTO.getAddress());
            pe.setPrice(propertyDTO.getPrice());
            pe.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()) {
            PropertyEntity pe = optEn.get();//data fom database
            pe.setDescription(propertyDTO.getDescription());
            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        PropertyDTO dto = null;
        if(optEn.isPresent()) {
            PropertyEntity pe = optEn.get();//data fom database
            pe.setPrice(propertyDTO.getPrice());
            dto = propertyConverter.convertEntityToDTO(pe);
            propertyRepository.save(pe);
        }
        return dto;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
