package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.impl.PropertyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceImplTest {

    @InjectMocks
    private PropertyServiceImpl propertyServiceImpl;

    @Mock
    private PropertyConverter propertyConverter;

    @Mock
    private PropertyRepository propertyRepository;

    @Test
    void testSaveProperty_Success(){

        PropertyDTO dto = new PropertyDTO();
        dto.setTitle("Dummy");

        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle("Dummy");

        PropertyEntity savedEntity = new PropertyEntity();
        savedEntity.setTitle("Dummy");
        savedEntity.setId(1L);

        PropertyDTO savedDTO = new PropertyDTO();
        savedDTO.setTitle("Dummy");
        savedDTO.setId(1L);

        Mockito.when(propertyConverter.convertDTOToEntity(Mockito.any())).thenReturn(propertyEntity);
        Mockito.when(propertyRepository.save(Mockito.any())).thenReturn(savedEntity);
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDTO);

        PropertyDTO result = propertyServiceImpl.saveProperty(dto);

        Assertions.assertEquals(savedDTO.getId(), result.getId());
    }

    @Test
    void testTetAllProperties_Success(){

        List<PropertyEntity> propertyEntities = new ArrayList<>();
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setId(1L);
        propertyEntity.setTitle("Dummy");
        propertyEntities.add(propertyEntity);

        PropertyDTO savedDTO = new PropertyDTO();
        savedDTO.setTitle("Dummy");
        savedDTO.setId(1L);

        Mockito.when(propertyRepository.findAll()).thenReturn(propertyEntities);
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDTO);
        List<PropertyDTO> listPropDTO = propertyServiceImpl.getAllProperties();

        Assertions.assertEquals(1, listPropDTO.size());
    }

    @Test
    void testTetAllProperties_wt_2_Entities_Success(){

        List<PropertyEntity> propertyEntities = new ArrayList<>();
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setId(1L);
        propertyEntity.setTitle("Dummy 1");
        propertyEntities.add(propertyEntity);

        propertyEntity = new PropertyEntity();
        propertyEntity.setId(2L);
        propertyEntity.setTitle("Dummy 2");
        propertyEntities.add(propertyEntity);

        List<PropertyDTO> propertyDTOList = new ArrayList<>();
        PropertyDTO savedDTO = new PropertyDTO();
        savedDTO.setTitle("Dummy");
        savedDTO.setId(1L);
        propertyDTOList.add(savedDTO);

        savedDTO = new PropertyDTO();
        savedDTO.setTitle("Dummy 2");
        savedDTO.setId(2L);
        propertyDTOList.add(savedDTO);

        Mockito.when(propertyRepository.findAll()).thenReturn(propertyEntities);
        //Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDTO);
        /*for(PropertyDTO dto: propertyDTOList){
            Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(dto);
        }*/
        //Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(propertyDTOList.get(0));
        //Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(propertyDTOList.get(1));

        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(propertyDTOList.get(0), propertyDTOList.get(1));

        List<PropertyDTO> listPropDTO = propertyServiceImpl.getAllProperties();

        Assertions.assertEquals(2, listPropDTO.size());
    }

    @Test
    void testUpdateProperty_success(){
        PropertyDTO savedDTO = new PropertyDTO();
        savedDTO.setTitle("Dummy");
        savedDTO.setId(1L);
        savedDTO.setPrice(234455.4);
        savedDTO.setAddress("xyz");
        savedDTO.setDescription("abc");
        savedDTO.setOwnerEmail("ad@gmail.com");
        savedDTO.setOwnerName("AD XY");

        PropertyEntity pe = new PropertyEntity();
        pe.setId(1L);
        pe.setTitle("Dummy");
        pe.setPrice(234455.4);
        pe.setAddress("xyz");
        pe.setDescription("abc");
        pe.setOwnerEmail("ad@gmail.com");
        pe.setOwnerName("AD XY");

        when(propertyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(pe));
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDTO);
        //when(propertyRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        //Mockito.lenient().when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDTO);

        PropertyDTO updatedProperty = propertyServiceImpl.updateProperty(savedDTO, 1L);

        //Assertions.assertNull(updatedProperty);
        Assertions.assertEquals(savedDTO.getTitle(), updatedProperty.getTitle());
        Assertions.assertEquals(savedDTO.getPrice(), updatedProperty.getPrice());
        Assertions.assertEquals(savedDTO.getAddress(), updatedProperty.getAddress());
        Assertions.assertEquals(savedDTO.getDescription(), updatedProperty.getDescription());
        Assertions.assertEquals(savedDTO.getOwnerEmail(), updatedProperty.getOwnerEmail());
        Assertions.assertEquals(savedDTO.getOwnerName(), updatedProperty.getOwnerName());
    }

    @Test
    void testUpdatePropertyDescription_Success(){

        PropertyDTO savedDTO = new PropertyDTO();
        savedDTO.setTitle("Dummy");
        savedDTO.setId(1L);
        savedDTO.setPrice(234455.4);
        savedDTO.setAddress("xyz");
        savedDTO.setOwnerEmail("ad@gmail.com");
        savedDTO.setOwnerName("AD XY");
        savedDTO.setDescription("updated abc");

        PropertyEntity pe = new PropertyEntity();
        pe.setId(1L);
        pe.setTitle("Dummy");
        pe.setPrice(234455.4);
        pe.setAddress("xyz");
        pe.setDescription("abc");
        pe.setOwnerEmail("ad@gmail.com");
        pe.setOwnerName("AD XY");

        Mockito.when(propertyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(pe));
        Mockito.when(propertyConverter.convertEntityToDTO(Mockito.any())).thenReturn(savedDTO);

        PropertyDTO updatedProperty = propertyServiceImpl.updatePropertyDescription(savedDTO, 1L);
        Assertions.assertEquals(savedDTO.getDescription(), updatedProperty.getDescription());
    }

    @Test
    void testUpdatePropertyDescription_Failure(){

        PropertyDTO savedDTO = new PropertyDTO();

        Mockito.when(propertyRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        /*ApplicationException thrown = Assertions.assertThrows(ApplicationException.class, () -> {
            //Code under test
        });

        Assertions.assertEquals("some message", exception.getMessage());*/

        BusinessException exception = Assertions.assertThrows(BusinessException.class, () -> {
            PropertyDTO updatedDTO = propertyServiceImpl.updatePropertyDescription(savedDTO, 1L);
        });

        Assertions.assertEquals("No Propery Found for update", exception.getMessage());
    }

    @Test
    void testDeleteProperty(){
        propertyServiceImpl.deleteProperty(1L);
        Mockito.verify(propertyRepository, Mockito.times(1)).deleteById(1L);

        /*ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        Mockito.verify(propertyRepository).deleteById(argumentCaptor.capture());
        Long capturedArgument = argumentCaptor.getValue();
        Assertions.assertEquals(1L, argumentCaptor.getValue());*/
    }
}
