package com.clinic.model;

import javax.persistence.*;

@Entity
@Table(name = "user_roles", uniqueConstraints = @UniqueConstraint(
                columnNames = { "role", "email" }))
public class UserRole {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_role_id")
    private Integer userRoleId;

    @Column(name = "role", nullable = false, length = 45)
    private String role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email", nullable = false)
    private User user;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
