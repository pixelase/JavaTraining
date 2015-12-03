package com.github.pixelase.webproject.dataaccess.model;
// Generated 02.12.2015 21:41:29 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * WorkRequest generated by hbm2java
 */
@Entity
@Table(name = "work_request")
public class WorkRequest implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private Tenant tenant;
	private WorkScope workScope;
	private WorkType workType;
	private Date desiredDate;
	private Set<Brigade> brigades = new HashSet<Brigade>(0);

	public WorkRequest() {
		super();
	}

	public WorkRequest(int id) {
		super();
		this.id = id;
	}

	public WorkRequest(Tenant tenant, WorkScope workScope, WorkType workType, Date desiredDate) {
		super();
		this.tenant = tenant;
		this.workScope = workScope;
		this.workType = workType;
		this.desiredDate = desiredDate;
	}

	public WorkRequest(int id, Tenant tenant, WorkScope workScope, WorkType workType, Date desiredDate) {
		super();
		this.id = id;
		this.tenant = tenant;
		this.workScope = workScope;
		this.workType = workType;
		this.desiredDate = desiredDate;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tenant_id")
	public Tenant getTenant() {
		return this.tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "work_scope_id")
	public WorkScope getWorkScope() {
		return this.workScope;
	}

	public void setWorkScope(WorkScope workScope) {
		this.workScope = workScope;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "work_type_id")
	public WorkType getWorkType() {
		return this.workType;
	}

	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "desired_date", length = 13)
	public Date getDesiredDate() {
		return this.desiredDate;
	}

	public void setDesiredDate(Date desiredDate) {
		this.desiredDate = desiredDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workRequest")
	public Set<Brigade> getBrigades() {
		return this.brigades;
	}

	public void setBrigades(Set<Brigade> brigades) {
		this.brigades = brigades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof WorkRequest))
			return false;
		WorkRequest other = (WorkRequest) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WorkRequest [id=" + id + ", tenant=" + tenant + ", workScope=" + workScope + ", workType=" + workType
				+ ", desiredDate=" + desiredDate + "]";
	}

}
