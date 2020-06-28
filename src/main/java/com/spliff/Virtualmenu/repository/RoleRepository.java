package com.spliff.Virtualmenu.repository;


import com.spliff.Virtualmenu.entity.authModel.Role;
import com.spliff.Virtualmenu.entity.authModel.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
