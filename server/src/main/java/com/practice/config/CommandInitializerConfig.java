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

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CommandInitializerConfig implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository; // Repositorio para los permisos
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
            // Obtener todos los permisos
            Set<PermissionModel> allPermissions = new HashSet<>(permissionRepository.findAll());

            // Crear rol ADMIN con todos los permisos
            RoleModel adminRole = new RoleModel(EnumRole.ADMIN);
            adminRole.setPermissions(allPermissions);
            roleRepository.save(adminRole);

            // Crear rol USER sin permisos al inicio
            RoleModel userRole = new RoleModel(EnumRole.USER);
            roleRepository.save(userRole);


            System.out.println("Roles initialized.");
        }

        // Crear un administrador inicial
        if (userRepository.count() == 0) {
            RoleModel adminRole = roleRepository.findByEnumRole(EnumRole.ADMIN)
                    .orElseThrow(() -> new RuntimeException("El rol ADMIN no existe"));

            UserModel admin = new UserModel();
            admin.setEmail("admin@example.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRoles(Set.of(adminRole));

            userRepository.save(admin);

            System.out.println("Admin user created: admin@example.com / admin123");
        }
    }
}

