package com.muhardin.endy.belajar.springvue.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data @Entity
@Table(name = "s_permissions")
public class Permission {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @NotNull @NotEmpty
    @Column(name = "permission_label")
    private String label;
    
    @NotNull @NotEmpty
    @Column(name = "permission_value")
    private String value;
}
