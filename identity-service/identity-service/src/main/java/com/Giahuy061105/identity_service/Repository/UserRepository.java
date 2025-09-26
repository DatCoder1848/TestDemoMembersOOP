package com.Giahuy061105.identity_service.Repository;

import com.Giahuy061105.identity_service.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
