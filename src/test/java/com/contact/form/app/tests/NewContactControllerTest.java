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
import com.contact.form.app.controller.NewContactController;
import com.contact.form.app.dao.CarDao;

public class NewContactControllerTest {
	
	private String NEW_CONTACT_TEST_URL = "";
	
	@Mock
	private CarDao carDao;
 
    @InjectMocks
    private NewContactController newContactController;
 
    private MockMvc mockMvc;
 
    @Before
    public void setup() {
 
        // process mock annotations
        MockitoAnnotations.initMocks(this);
 
        // setup spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(newContactController).build();
        
        // setup spring test in standalone 
        ConfigurationProperties config = new ConfigurationProperties();
        try {
        	NEW_CONTACT_TEST_URL = config.getConfigurationValues().getDeploymentUrl().concat("/contacts/new/index");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @Test
    public void testContactFormGetRequest() throws Exception {
        this.mockMvc.perform(get(NEW_CONTACT_TEST_URL))
        .andExpect(status().isOk());
    }
    
    @Test
    public void testContactFormPostRequest() throws Exception {
        this.mockMvc.perform(post(NEW_CONTACT_TEST_URL)
                .param("firstName", "FirstName")
                .param("lastName", "LastName")
                .param("emailAddress", "email@email.com")
                .param("phoneNumber", "555-555-5555")
                .param("model", "Model")
                .param("message", "Hello World!"))
                .andExpect(status().isOk());
    }
}