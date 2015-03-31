package com.contact.form.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

@Entity
@Table(name = "car")
public class Car {
	
	@Id
	@GeneratedValue
    private long id;

    @NotBlank(message = "Model name cannot be blank")
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.NONE, message = "No HTML/JavaScript allowed")
    @Pattern(regexp = "^(?!.*[`~$&+.,:;=?@#|/'<>^*(){}%!\"\\[\\]-]).*$", message = "No special characters allowed")
    @Size(max = 75, message = "Model name cannot be longer than {max} characters")
    private String model;
    
    public Car() {
    	
    }
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}