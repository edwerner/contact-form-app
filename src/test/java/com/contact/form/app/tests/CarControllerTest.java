package com.contact.form.app.tests;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.contact.form.app.configuration.ConfigurationProperties;
import com.contact.form.app.controller.CarController;
import com.contact.form.app.dao.CarDao;

public class CarControllerTest {
	
	private String NEW_CAR_TEST_URL = "";
	private String LIST_ALL_CARS_TEST_URL = "";
	private String CARS_JSON_TEST_URL = "";
	private String LIST_CAR_BY_ID_TEST_URL = "";
	private String DELETE_CAR_BY_ID_TEST_URL = "";
	
	@Mock
	private CarDao carDao;
 
    @InjectMocks
    private CarController carController;
 
    private MockMvc mockMvc;
 
    @Before
    public void setup() {
 
        // process mock annotations
        MockitoAnnotations.initMocks(this);
 
        // setup spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
        
        ConfigurationProperties config = new ConfigurationProperties();
        
        try {
        	NEW_CAR_TEST_URL = config.getConfigurationValues().getDeploymentUrl().concat("/cars/new/index");
        	LIST_ALL_CARS_TEST_URL = config.getConfigurationValues().getDeploymentUrl().concat("/cars/list/all");
        	CARS_JSON_TEST_URL = config.getConfigurationValues().getDeploymentUrl().concat("/cars/carsJson");
        	LIST_CAR_BY_ID_TEST_URL = config.getConfigurationValues().getDeploymentUrl().concat("/cars/list/testCarId");
        	DELETE_CAR_BY_ID_TEST_URL = config.getConfigurationValues().getDeploymentUrl().concat("/cars/delete/testCarId");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @Test
    public void testNewContactGetRequest() throws Exception {
        this.mockMvc.perform(get(NEW_CAR_TEST_URL))
        .andExpect(status().isOk());
    }
    
    @Test
    public void testNewContactPostRequest() throws Exception {
        this.mockMvc.perform(post(NEW_CAR_TEST_URL)
                .param("model", "Model"))
                .andExpect(status().isOk());
    }

    @Test
    public void testListAllCars() throws Exception {
        this.mockMvc.perform(get(LIST_ALL_CARS_TEST_URL))
        .andExpect(status().isOk());
    }

    @Test
    public void testCarsJson() throws Exception {
        this.mockMvc.perform(get(CARS_JSON_TEST_URL))
        .andExpect(status().isOk());
    }

    @Test
    public void testListCarsById() throws Exception {
        this.mockMvc.perform(get(LIST_CAR_BY_ID_TEST_URL))
        .andExpect(status().isOk());
    }

    @Test
    public void testDeleteCarById() throws Exception {
        this.mockMvc.perform(get(DELETE_CAR_BY_ID_TEST_URL))
        .andExpect(status().isOk());
    }
}