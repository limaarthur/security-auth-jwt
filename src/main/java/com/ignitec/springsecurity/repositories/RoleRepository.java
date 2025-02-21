package com.ignitec.springsecurity.repositories;

import com.ignitec.springsecurity.entities.Role;
import com.ignitec.springsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
