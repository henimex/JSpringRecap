package com.henimex.jspringrecap.core.dataAccess;

import com.henimex.jspringrecap.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
