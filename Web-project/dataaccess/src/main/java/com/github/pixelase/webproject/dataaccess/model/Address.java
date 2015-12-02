package com.github.pixelase.webproject.dataaccess.model;
// Generated 02.12.2015 21:41:29 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Address generated by hbm2java
 */
@Entity
@Table(name = "address", schema = "public")
public class Address implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String street;
	private String house;
	private String apartment;
	private Set<Tenant> tenants = new HashSet<Tenant>(0);

	public Address() {
	}

	public Address(int id) {
		this.id = id;
	}

	public Address(int id, String street, String house, String apartment, Set<Tenant> tenants) {
		this.id = id;
		this.street = street;
		this.house = house;
		this.apartment = apartment;
		this.tenants = tenants;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "street")
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "house")
	public String getHouse() {
		return this.house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	@Column(name = "apartment")
	public String getApartment() {
		return this.apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	public Set<Tenant> getTenants() {
		return this.tenants;
	}

	public void setTenants(Set<Tenant> tenants) {
		this.tenants = tenants;
	}

}