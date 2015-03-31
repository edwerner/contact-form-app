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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.contact.form.app.configuration.ConfigurationProperties;
import com.contact.form.app.controller.ApplicationController;
import com.contact.form.app.dao.CarDao;
import com.contact.form.app.dao.ContactDao;

public class ApplicationControllerTest {
	
	private String APPLICATION_CONTROLLER_TEST_URL = "";
	
	@Mock
	private CarDao carDao;
	
    @Mock
	private ContactDao contactDao;
 
    @InjectMocks
    private ApplicationController applicationController;
 
    private MockMvc mockMvc;
 
    @Before
    public void setup() {
 
        // process mock annotations
        MockitoAnnotations.initMocks(this);
 
        // setup spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(applicationController).build();
        
        ConfigurationProperties config = new ConfigurationProperties();
        try {
        	APPLICATION_CONTROLLER_TEST_URL = config.getConfigurationValues().getDeploymentUrl().concat("/");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @Test
    public void verifyApplicationController() throws Exception {
        this.mockMvc.perform(get(APPLICATION_CONTROLLER_TEST_URL))
        .andExpect(status().isOk());
    }
}