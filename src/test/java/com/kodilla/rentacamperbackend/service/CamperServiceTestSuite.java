//package com.kodilla.rentacamperbackend.service;
//
//import com.kodilla.rentacamperbackend.domain.Camper;
//import com.kodilla.rentacamperbackend.domain.Category;
//import com.kodilla.rentacamperbackend.repository.CamperRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class CamperServiceTestSuite {
//
//    @InjectMocks
//    CamperService camperService;
//    @Mock
//    CamperRepository camperRepository;
//
//    @Test
//    public void getAllCampersTest() {
//        //when
//        camperService.findAllCampers();
//        //then
//        verify(camperRepository, times(1)).findAll();
//    }
//
//    @Test
//    public void getCamperTest() {
//        //given
//        Camper camper = new Camper(1L, 6, 6, new BigDecimal(450), new ArrayList<>(),
//                new Category(), new ArrayList<>());
//        //when
//        camperService.getCamper(camper.getId());
//        //then
//        verify(camperRepository, times(1)).findById(1L);
//    }
//
//    @Test
//    public void saveCamperTest() {
//        //given
//        Camper camper = new Camper(1L, 6, 6, new BigDecimal(450), new ArrayList<>(),
//                new Category(), new ArrayList<>());
//        //when
//        camperService.saveCamper(camper);
//        //then
//        verify(camperRepository, times(1)).save(camper);
//    }
//
//    @Test
//    public void deleteCamperTest() {
//        //given
//        Camper camper = new Camper(1L, 6, 6, new BigDecimal(450), new ArrayList<>(),
//                new Category(), new ArrayList<>());
//        //when
//        camperService.deleteCamper(camper.getId());
//        //then
//        verify(camperRepository, times(1)).deleteById(1L);
//    }
//}
