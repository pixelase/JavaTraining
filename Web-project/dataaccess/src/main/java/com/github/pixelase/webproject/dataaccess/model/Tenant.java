package com.github.pixelase.webproject.dataaccess.model;
// Generated 02.12.2015 21:41:29 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tenant generated by hbm2java
 */
@Entity
@Table(name = "tenant", schema = "public")
public class Tenant implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Address address;
	private String firstName;
	private String lastName;
	private Set<WorkRequest> workRequests = new HashSet<WorkRequest>(0);

	public Tenant() {
	}

	public Tenant(int id) {
		this.id = id;
	}

	public Tenant(int id, Address address, String firstName, String lastName, Set<WorkRequest> workRequests) {
		this.id = id;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.workRequests = workRequests;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tenant")
	public Set<WorkRequest> getWorkRequests() {
		return this.workRequests;
	}

	public void setWorkRequests(Set<WorkRequest> workRequests) {
		this.workRequests = workRequests;
	}

}