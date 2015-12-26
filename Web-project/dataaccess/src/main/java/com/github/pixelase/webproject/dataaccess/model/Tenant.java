package com.github.pixelase.webproject.dataaccess.model;
// Generated 02.12.2015 21:41:29 by Hibernate Tools 4.3.1.Final

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Tenant generated by hbm2java
 */
@Entity
@Table(name = "tenant")
public class Tenant implements Persistable<Integer> {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private Account account;
    private Address address;
    private Set<WorkRequest> workRequests = new HashSet<WorkRequest>(0);

    public Tenant() {
        super();
    }

    public Tenant(Integer id) {
        super();
        this.id = id;
    }

    public Tenant(Account account, Address address) {
        super();
        this.account = account;
        this.address = address;
    }

    public Tenant(Integer id, Account account, Address address) {
        super();
        this.id = id;
        this.account = account;
        this.address = address;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "account_id", nullable = false)
    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
        if (account.getTenant() != this) {
            account.setTenant(this);
        }
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
        if (!address.getTenants().contains(this)) {
            address.getTenants().add(this);
        }
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tenant")
    public Set<WorkRequest> getWorkRequests() {
        return this.workRequests;
    }

    public void setWorkRequests(Set<WorkRequest> workRequests) {
        this.workRequests = workRequests;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Tenant))
            return false;
        Tenant other = (Tenant) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Tenant [id=" + id + ", account=" + account + ", address=" + address + "]";
    }

    @Override
    @Transient
    public boolean isNew() {
        return id == null;
    }

}
