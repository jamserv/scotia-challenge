package com.scotia.challenge.modularTest;

import com.scotia.challenge.api.commons.Constants;
import com.scotia.challenge.helper.HttpMockMvcComponent;
import com.scotia.challenge.car.model.Car;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.scotia.challenge.car.service.CarService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.integration.properties")
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
@Disabled
public class CarTest {

    private static final String URI = Constants.URI_CAR;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    CarService carService;

    @Autowired
    HttpMockMvcComponent mvcComponent;

    @Test
    public void runAllCases() throws Exception {
        add();
        edit();
        findAll();
        findOne();
        delete();
    }

    public void add() throws Exception {
        Car model = new Car();
        model.setModel("Honda Civic");
        model.setYear(2020);
        performAdd(model);
    }

    public void edit() throws Exception {
        Car model = carService.findAll().get(0);
        model.setYear(2021);

        performEdit(model);
    }

    public void findAll() throws Exception {
        performGetAll();
    }

    public void findOne() throws Exception {
        Car model = carService.findAll().get(0);
        performGetOne(model.getId());
    }

    public void delete() throws Exception {
        Car model = carService.findAll().get(0);
        performDelete(model.getId());
    }

    private void performAdd(Car model) throws Exception {
        Gson gson = new Gson();
        String o = gson.toJson(model);

        mockMvc.perform(mvcComponent.post(URI, o))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0));
    }

    private void performGetAll() throws Exception {
        mockMvc.perform(mvcComponent.getAll(URI))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0));
    }

    private void performGetOne(Long id) throws Exception {
        mockMvc.perform(mvcComponent.getById(URI, id))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0));
    }

    private void performEdit(Car model) throws Exception {
        Gson gson = new Gson();
        String o = gson.toJson(model);

        mockMvc.perform(mvcComponent.put(URI, o))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value(0));
    }

    private void performDelete(Long id) throws Exception {
        mockMvc.perform(mvcComponent.delete(URI, id))
                .andExpect(status().isOk());
    }
}
