//package com.sungwoo.aps.test;
//
//import com.sungwoo.aps.models.Car;
//import com.sungwoo.aps.repo.CarRepo;
//import com.sungwoo.aps.services.CarService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class CarRepoTests {
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private CarRepo carRepo;
//
//    @MockBean
//    private CarService carService;
//
//    @Test
//    public void whenFindByLicense() {
//        // given
//        Car bmw = new Car("52B2-75675");
//        entityManager.persist(bmw);
//        entityManager.flush();
//
//        // when
//        Car found = carRepo.findByLicense(bmw.getLicense());
//
//        // then
//        assertThat(found.getLicense())
//                .isEqualTo(bmw.getLicense());
//    }
//
////    @Test
////    public void testSayHelloWorld() throws Exception {
////        // given
////        Car bmw = new Car(UUID.randomUUID(),"52B2-75675");
////        entityManager.persist(bmw);
////        entityManager.flush();
////
////        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
////                "/info/"+bmw.getUid().toString()).accept(
////                MediaType.APPLICATION_JSON);
////
////        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
////
////        System.out.println(result.getResponse());
////        String expected = "{id:Course1,name:Spring,description:10 Steps}";
////
////        // {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}
////
////        JSONAssert.assertEquals(expected, result.getResponse()
////                .getContentAsString(), false);
////
////    }
//}
