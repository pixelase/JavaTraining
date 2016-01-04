package com.github.pixelase.webproject.dataaccess.model;
// Generated 23.12.2015 19:24:15 by Hibernate Tools 4.3.1.Final

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Role implements Persistable<Integer> {

    private Integer id;
    private String name;
    private Set<Account> accounts = new HashSet<>(0);

    public Role() {
        super();
    }

    public Role(Integer id) {
        super();
        this.id = id;
    }

    public Role(String name) {
        super();
        this.name = name;
    }

    public Role(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
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

    @Column(name = "name", unique = true)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_role", schema = "public", joinColumns = {
            @JoinColumn(name = "role_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "account_id", nullable = false, updatable = false)})
    public Set<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
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
        if (!(obj instanceof Role))
            return false;
        Role other = (Role) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Role [id=" + id + ", name=" + name + "]";
    }

    @Override
    @Transient
    public boolean isNew() {
        return id == null;
    }
}
