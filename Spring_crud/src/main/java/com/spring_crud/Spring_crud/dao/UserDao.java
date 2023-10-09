package com.spring_crud.Spring_crud.dao;

import com.spring_crud.Spring_crud.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<Users,Long> {

    public Users findByEmail(String email);


}
