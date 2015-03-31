package com.contact.form.app.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 
/**
 * @author Crunchify.com
 * 
 */
 
public class ConfigurationProperties {
 
	private String message;

	public ConfigurationProperties getConfigurationValues() throws IOException {

		String propFileName = "configuration.properties";
		InputStream inputStream = null;
		
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			Properties prop = new Properties();
			prop.load(inputStream);
			setDeploymentUrl(prop.getProperty("deploymentBaseUrl"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return this;
	}

	public String getDeploymentUrl() {
		return message;
	}

	public void setDeploymentUrl(String message) {
		this.message = message;
	}
}