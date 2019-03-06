package com.wandrstick.Repository;

import com.wandrstick.Model.Role;
import com.wandrstick.Model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
