package com.dawidonak.turneyapp.repository;

import com.dawidonak.turneyapp.domain.entity.Role;
import com.dawidonak.turneyapp.domain.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
