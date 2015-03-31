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
import com.contact.form.app.controller.ContactController;
import com.contact.form.app.dao.ContactDao;

public class ContactControllerTest {
	
	private String LIST_ALL_CONTACTS_TEST_URL = "";
	private String CONTACTS_JSON_TEST_URL = "";
	private String LIST_CONTACT_BY_ID_TEST_URL = "";
	private String DELETE_CONTACT_BY_ID_TEST_URL = "";
	
	@Mock
	ContactDao contactDao;
 
    @InjectMocks
    private ContactController newContactController;
 
    private MockMvc mockMvc;
 
    @Before
    public void setup() {
 
        // process mock annotations
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(newContactController).build();
        
        // setup spring test in standalone 
        ConfigurationProperties config = new ConfigurationProperties();
        try {
        	LIST_ALL_CONTACTS_TEST_URL = config.getConfigurationValues().getDeploymentUrl().concat("/contacts/list/all");
        	CONTACTS_JSON_TEST_URL = config.getConfigurationValues().getDeploymentUrl().concat("/contacts/contactsJson");
        	LIST_CONTACT_BY_ID_TEST_URL = config.getConfigurationValues().getDeploymentUrl().concat("/contacts/list/testContactId");
        	DELETE_CONTACT_BY_ID_TEST_URL = config.getConfigurationValues().getDeploymentUrl().concat("/contacts/delete/testContactId");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @Test
    public void testListAllContactsRequest() throws Exception {
        this.mockMvc.perform(get(LIST_ALL_CONTACTS_TEST_URL))
                .andExpect(status().isOk());
    }

    @Test
    public void testContactsJson() throws Exception {
        this.mockMvc.perform(get(CONTACTS_JSON_TEST_URL))
        .andExpect(status().isOk());
    }

    @Test
    public void testListContactById() throws Exception {
        this.mockMvc.perform(get(LIST_CONTACT_BY_ID_TEST_URL))
        .andExpect(status().isOk());
    }

    @Test
    public void testDeleteContactById() throws Exception {
        this.mockMvc.perform(get(DELETE_CONTACT_BY_ID_TEST_URL))
        .andExpect(status().isOk());
    }
}