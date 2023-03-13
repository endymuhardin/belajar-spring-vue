package com.muhardin.endy.belajar.springvue.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data @Entity
@Table(name = "s_users_passwords")
public class UserPassword {

    @Id @Column(name = "id_user")
    private String id;

    @OneToOne
    @PrimaryKeyJoinColumn(name="id_user", referencedColumnName="id")
    private User user;

    @NotNull @NotEmpty
    @Column(name = "user_password")
    private String password;
}
