package com.simpleSchedule.model;

import com.simpleSchedule.validator.PasswordMatches;
import com.simpleSchedule.validator.ValidEmail;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by SteveGreen on 03/09/15.
 *
 * This class will represent the basic user of the system.
 */

@Entity
@PasswordMatches
@Table(name = "user_accounts")
public class User implements Serializable{

    private static final long serialVersionUID = 135498375435098L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //set to identity for postgres serial
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 1)
    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min = 2)
    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }

//    //todo: will need validator / lookup to ensure unique
//    @NotNull
//    @NotEmpty
//    @Size(min = 10)
//    private String username;

    @NotNull
    @NotEmpty
    @Column(name = "password", length = 255)
    private String password;

    @NotNull
    @NotEmpty
    @ValidEmail
    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 20, nullable = false)
    private Role role;

    public Role getRole() {
        return role;
    }

    public SocialMediaService getSignInProvider() {
        return signInProvider;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "sign_in_provider", length = 20)
    private SocialMediaService signInProvider;

//    @Transient //temporary change to test user class and db interaction
//    private boolean enabled;

//    public boolean isTokenExpired() {
//        return tokenExpired;
//    }
//
//    public void setTokenExpired(boolean tokenExpired) {
//        this.tokenExpired = tokenExpired;
//    }
//
//    public boolean isEnabled() {
//        return enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    @Transient //temporary change to test user class and db interaction
//    private boolean tokenExpired;

//    public User(){
//        this.enabled = false;
//        this.tokenExpired = false;
//    }
//
//
//    public User(String firstName, String lastName, String username, String password, String email) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.enabled = false;
//        this.tokenExpired = false;
//    }

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //todo: this could just as easily be jquery instead.
    public String getMatchingPassword() {
        return this.password;
    }
}
