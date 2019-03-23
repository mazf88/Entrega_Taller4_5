package com.poli.online_sale.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "order")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "orderId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "costummerId")
    private Costumer costumerId;
	
	
	@Column(name = "orderDescription")
	private String orderDescription;
	
	
	@Column(name = "deliveryAddress")
	private String deliveryAddress;
	
	@Column(name = "billingAddress")
	private String billingAddress;


	@Column(name = "purchaseDate")
	private Date purchaseDate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="orderId")
	private Set<OrderedProduct> orderedProduct = new HashSet<OrderedProduct>(0);
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderStatusId")
    private OrderStatus orderStatusId;

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the costumerId
	 */
	public Costumer getCostumerId() {
		return costumerId;
	}

	/**
	 * @param costumerId the costumerId to set
	 */
	public void setCostumerId(Costumer costumerId) {
		this.costumerId = costumerId;
	}

	/**
	 * @return the orderDescription
	 */
	public String getOrderDescription() {
		return orderDescription;
	}

	/**
	 * @param orderDescription the orderDescription to set
	 */
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	/**
	 * @return the deliveryAddress
	 */
	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * @param deliveryAddress the deliveryAddress to set
	 */
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	/**
	 * @return the billingAddress
	 */
	public String getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress the billingAddress to set
	 */
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * @return the purchaseDate
	 */
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * @param purchaseDate the purchaseDate to set
	 */
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	/**
	 * @return the orderedProduct
	 */
	public Set<OrderedProduct> getOrderedProduct() {
		return orderedProduct;
	}

	/**
	 * @param orderedProduct the orderedProduct to set
	 */
	public void setOrderedProduct(Set<OrderedProduct> orderedProduct) {
		this.orderedProduct = orderedProduct;
	}

	/**
	 * @return the orderStatusId
	 */
	public OrderStatus getOrderStatusId() {
		return orderStatusId;
	}

	/**
	 * @param orderStatusId the orderStatusId to set
	 */
	public void setOrderStatusId(OrderStatus orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	
	
}
