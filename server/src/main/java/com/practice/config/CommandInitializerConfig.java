package com.practice.config;

import com.practice.User.Enum.EnumPermission;
import com.practice.User.Enum.EnumRole;
import com.practice.User.model.PermissionModel;
import com.practice.User.model.RoleModel;
import com.practice.User.model.UserModel;
import com.practice.User.repository.PermissionRepository;
import com.practice.User.repository.RoleRepository;
import com.practice.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Component
@RequiredArgsConstructor
public class CommandInitializerConfig implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Inicializar permisos
        if (permissionRepository.count() == 0) {
            for (EnumPermission permission : EnumPermission.values()) {
                PermissionModel newPermission = new PermissionModel();
                newPermission.setName(permission.name());
                permissionRepository.save(newPermission);
            }
            System.out.println("Permissions initialized.");
        }

        // Inicializar roles
        if (roleRepository.count() == 0) {
            Set<PermissionModel> allPermissions = new HashSet<>(permissionRepository.findAll());

            RoleModel adminRole = new RoleModel(EnumRole.ADMIN);
            adminRole.setPermissions(allPermissions);
            roleRepository.save(adminRole);

            RoleModel userRole = new RoleModel(EnumRole.USER);
            roleRepository.save(userRole);

            System.out.println("Roles initialized.");
        }

        // Crear usuarios iniciales
        if (userRepository.count() == 0) {
            RoleModel adminRole = roleRepository.findByEnumRole(EnumRole.ADMIN)
                    .orElseThrow(() -> new RuntimeException("El rol ADMIN no existe"));
            RoleModel userRole = roleRepository.findByEnumRole(EnumRole.USER)
                    .orElseThrow(() -> new RuntimeException("El rol USER no existe"));

            UserModel admin = UserModel.builder()
                    .email("admin@example.com")
                    .password(passwordEncoder.encode("admin123"))
                    .name("Ryan")
                    .lastName("Gonzales")
                    .phoneNumber(123456789)
                    .birthDate(LocalDateTime.of(1980, 1, 1, 0, 0))
                    .registerDate(LocalDateTime.now())
                    .lastLogin(LocalDateTime.now())
                    .roles(Set.of(adminRole))
                    .photoUrl("https://i.sstatic.net/l60Hf.png")
                    .build();

            UserModel user1 = UserModel.builder()
                    .email("user1@example.com")
                    .password(passwordEncoder.encode("user123"))
                    .name("Jhon")
                    .lastName("Perez")
                    .phoneNumber(123456789)
                    .birthDate(LocalDateTime.of(1990, 1, 1, 0, 0))
                    .registerDate(LocalDateTime.now())
                    .lastLogin(LocalDateTime.now())
                    .roles(Set.of(userRole))
                    .photoUrl("https://i.sstatic.net/l60Hf.png")
                    .build();

            UserModel user2 = UserModel.builder()
                    .email("user2@example.com")
                    .password(passwordEncoder.encode("password2"))
                    .name("Rodrigo")
                    .lastName("Mendez")
                    .phoneNumber(987654321)
                    .birthDate(LocalDateTime.of(1992, 2, 2, 0, 0))
                    .registerDate(LocalDateTime.now())
                    .lastLogin(LocalDateTime.now())
                    .roles(Set.of(userRole))
                    .photoUrl("https://i.sstatic.net/l60Hf.png")
                    .build();

            userRepository.save(admin);
            userRepository.save(user1);
            userRepository.save(user2);

            System.out.println("Initial users created.");
        }
    }
}

