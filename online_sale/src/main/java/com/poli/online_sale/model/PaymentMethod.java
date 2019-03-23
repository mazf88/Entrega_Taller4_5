package com.poli.online_sale.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "paymentmethod")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
public class PaymentMethod implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "paymentmethodId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentmethodId;

	@Column(name = "paymentmethodName")
	private String paymentmethodName;
	
	@Column(name = "paymentmethodState")
	private int paymentmethodState;

	public Long getPaymentmethodId() {
		return paymentmethodId;
	}

	public void setPaymentmethodId(Long paymentmethodId) {
		this.paymentmethodId = paymentmethodId;
	}

	public String getPaymentmethodName() {
		return paymentmethodName;
	}

	public void setPaymentmethodName(String paymentmethodName) {
		this.paymentmethodName = paymentmethodName;
	}

	public int getPaymentmethodState() {
		return paymentmethodState;
	}

	public void setPaymentmethodState(int paymentmethodState) {
		this.paymentmethodState = paymentmethodState;
	}
}