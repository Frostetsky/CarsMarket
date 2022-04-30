package com.carmarket.app.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles", uniqueConstraints = @UniqueConstraint(columnNames = "role"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRole  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "index")
    private long id;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
}
