package com.poli.online_sale.model;

import java.io.Serializable;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "costumer")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
        allowGetters = true)
public class Costumer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "costumerId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long costumerId;
	
	
	@Column(name = "costumerName")
	private String costumerName;
	
	
	@Column(name = "costumerSurname")
	private String costumerSurname;
	
	
	@Column(name = "costumerPassword")
	private String costumerPassword;
	
	
	@Column(name = "costumerGender")
	private String costumerGender;
	
	
	@Email
	@Column(name = "costumerEmail")
	private String costumerEmail;
	

	@Column(name = "costumerPhone")
	private String costumerPhone;

	public Long getCostumerId() {
		return costumerId;
	}

	public void setCostumerId(Long costumerId) {
		this.costumerId = costumerId;
	}

	public String getCostumerName() {
		return costumerName;
	}

	public void setCostumerName(String costumerName) {
		this.costumerName = costumerName;
	}

	public String getCostumerSurname() {
		return costumerSurname;
	}

	public void setCostumerSurname(String costumerSurname) {
		this.costumerSurname = costumerSurname;
	}

	public String getCostumerPassword() {
		return costumerPassword;
	}

	public void setCostumerPassword(String costumerPassword) {
		this.costumerPassword = costumerPassword;
	}

	public String getCostumerGender() {
		return costumerGender;
	}

	public void setCostumerGender(String costumerGender) {
		this.costumerGender = costumerGender;
	}

	public String getCostumerEmail() {
		return costumerEmail;
	}

	public void setCostumerEmail(String costumerEmail) {
		this.costumerEmail = costumerEmail;
	}

	public String getCostumerPhone() {
		return costumerPhone;
	}

	public void setCostumerPhone(String costumerPhone) {
		this.costumerPhone = costumerPhone;
	}

	@Override
	public String toString() {
		return "Costumer [costumerId=" + costumerId + ", costumerName=" + costumerName + ", costumerSurname="
				+ costumerSurname + ", costumerPassword=" + costumerPassword + ", costumerGender=" + costumerGender
				+ ", costumerEmail=" + costumerEmail + ", costumerPhone="
				+ costumerPhone + "]";
	}
	
}
