package com.github.pixelase.webproject.dataaccess.model;
// Generated 23.12.2015 19:24:15 by Hibernate Tools 4.3.1.Final

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Account generated by hbm2java
 */
@Entity
@Table(name = "account", uniqueConstraints = @UniqueConstraint(name = "uk_account_login_email", columnNames = {"login", "email"}))
public class Account implements Persistable<Integer> {

    private Integer id;
    private String login;
    private String email;
    private String cryptedPassword;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Set<Role> roles = new HashSet<Role>(0);
    private Employee employee;
    private Tenant tenant;

    public Account() {
        super();
    }

    public Account(Integer id) {
        super();
        this.id = id;
    }

    public Account(String login, String email, String cryptedPassword, String firstName, String lastName,
                   Date birthDate) {
        super();
        this.login = login;
        this.email = email;
        this.cryptedPassword = cryptedPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Account(Integer id, String login, String email, String cryptedPassword, String firstName, String lastName,
                   Date birthDate) {
        super();
        this.id = id;
        this.login = login;
        this.email = email;
        this.cryptedPassword = cryptedPassword;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
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

    @Column(name = "login", nullable = false, length = 20)
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "crypted_password", nullable = false)
    public String getCryptedPassword() {
        return this.cryptedPassword;
    }

    public void setCryptedPassword(String cryptedPassword) {
        this.cryptedPassword = cryptedPassword;
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

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date", length = 13)
    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "account_role", schema = "public", joinColumns = {
            @JoinColumn(name = "account_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "role_id", nullable = false, updatable = false)})
    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "account")
    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "account")
    public Tenant getTenant() {
        return this.tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
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
        if (!(obj instanceof Account))
            return false;
        Account other = (Account) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", login=" + login + ", email=" + email + ", cryptedPassword=" + cryptedPassword
                + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", roles="
                + roles + "]";
    }

    @Override
    @Transient
    public boolean isNew() {
        return id == null;
    }

}