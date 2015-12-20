package com.github.pixelase.webproject.dataaccess.model;
// Generated 02.12.2015 21:41:29 by Hibernate Tools 4.3.1.Final

import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee")
public class Employee implements Persistable<Integer> {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private WorkType workType;
    private String firstName;
    private String lastName;
    private Long salary;
    private Set<Brigade> brigades = new HashSet<Brigade>(0);

    public Employee() {
        super();
    }

    public Employee(Integer id) {
        super();
        this.id = id;
    }

    public Employee(WorkType workType, String firstName, String lastName, Long salary) {
        super();
        this.workType = workType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Employee(Integer id, WorkType workType, String firstName, String lastName, Long salary) {
        super();
        this.id = id;
        this.workType = workType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_type_id")
    public WorkType getWorkType() {
        return this.workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
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

    @Column(name = "salary")
    public Long getSalary() {
        return this.salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "brigade_member", schema = "public", joinColumns = {
            @JoinColumn(name = "employee_id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "brigade_id", nullable = false, updatable = false)})
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Employee))
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", workType=" + workType + ", firstName=" + firstName + ", lastName=" + lastName
                + ", salary=" + salary + "]";
    }

    @Override
    @Transient
    public boolean isNew() {
        return id == null;
    }

}
