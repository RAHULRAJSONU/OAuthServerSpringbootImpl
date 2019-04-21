package com.silvertech.OAuthServerSpringbootImpl.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="user")
@Data
public class User {

    User(){}

    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.enabled = user.isEnabled();
        this.accountNonExpired = user.isAccountNonExpired();
        this.credentialsNonExpired = user.isCredentialsNonExpired();
        this.accountNonLocked = user.isAccountNonLocked();
        this.roles = user.getRoles();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "account_non_expired")
    private boolean accountNonExpired;
    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;
    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;


}
