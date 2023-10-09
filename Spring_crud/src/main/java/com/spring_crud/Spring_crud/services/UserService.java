package com.spring_crud.Spring_crud.services;
import com.spring_crud.Spring_crud.entities.Users;

import java.util.List;
public interface UserService {

    public List<Users> getUsers();
    public Users addUser(Users user);
    public boolean findUser(Users user);

    public boolean deleteUser(Long userId);
}
