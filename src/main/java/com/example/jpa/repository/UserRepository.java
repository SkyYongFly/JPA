package com.example.jpa.repository;

import com.example.jpa.daomain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhuyong
 * @version V1.0.0
 * @date 2018/10/9 14:50
 */
public interface UserRepository extends JpaRepository<User, Long>{
}
