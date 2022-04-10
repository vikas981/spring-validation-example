package com.vikash.springvalidation.repository;

import com.vikash.springvalidation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
