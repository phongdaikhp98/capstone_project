package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "user")
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
public class User extends BaseEntity {
    @Column(insertable = true, updatable = true, nullable = false, unique = true)
    private String username;

    @JsonIgnore
    @Column(insertable = true, updatable = true, nullable = false)
    private String password;


    @Column(insertable = true, updatable = true, nullable = false)
    private String firstname;


    @Column(insertable = true, updatable = true, nullable = false)
    private String lastname;
}
