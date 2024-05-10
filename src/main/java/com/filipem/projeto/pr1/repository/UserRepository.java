package com.filipem.projeto.pr1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filipem.projeto.pr1.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    
}
