package com.poli.online_sale.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "orderedProduct")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class OrderedProduct implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "orderedProductId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderedProductId;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", nullable= true)
    private Order orderId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product productId;
	
	@Column(name = "orderedProductQuantity")
	private int orderedProductQuantity;
	
	@Column(name = "orderedProductPrice")
	private float orderedProductPrice;

	public Long getOrderedProductId() {
		return orderedProductId;
	}

	public void setOrderedProductId(Long orderedProductId) {
		this.orderedProductId = orderedProductId;
	}

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public int getOrderedProductQuantity() {
		return orderedProductQuantity;
	}

	public void setOrderedProductQuantity(int orderedProductQuantity) {
		this.orderedProductQuantity = orderedProductQuantity;
	}

	public float getOrderedProductPrice() {
		return orderedProductPrice;
	}

	public void setOrderedProductPrice(float orderedProductPrice) {
		this.orderedProductPrice = orderedProductPrice;
	}	
}
