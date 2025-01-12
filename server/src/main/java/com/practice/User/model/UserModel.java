package com.practice.User.model;

import com.practice.Cost.model.CostModel;
import com.practice.FinancingProfile.model.FinancingProfileModel;
import com.practice.Notification.model.NotificationModel;
import com.practice.Wallet.model.WalletModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(unique = true)
    private String email;

    private String password;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    @Column(name = "register_date")
    private LocalDateTime registerDate = LocalDateTime.now();

    @Column(name = "last_login")
    private LocalDateTime lastLogin = LocalDateTime.now();


    @OneToOne
    @JoinColumn(name = "financing_profile_id")
    FinancingProfileModel financingProfile;

    @OneToMany(mappedBy = "user")
    private Set<CostModel> costModel = new HashSet<>();
    @OneToMany(mappedBy = "user")
    private Set<WalletModel> walletModel = new HashSet<>();
    @OneToMany(mappedBy = "user")
    private Set<NotificationModel> notificationModel = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleModel.class)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleModel> roles = new HashSet<>();
}
