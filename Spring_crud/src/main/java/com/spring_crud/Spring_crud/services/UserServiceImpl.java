package com.spring_crud.Spring_crud.services;

import com.spring_crud.Spring_crud.dao.UserDao;
import com.spring_crud.Spring_crud.entities.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{

//    List<Users> list;
    @Autowired
    private UserDao userDao;
    public UserServiceImpl(){
    }

    @Override
    public List<Users> getUsers(){
        return userDao.findAll();
    }

    @Override
    public Users addUser(Users user){
//        list.add(user);
        userDao.save(user);
        return user;
    }

    @Override
    public boolean findUser(Users user){

        Users databaseUser=userDao.findByEmail(user.getEmail());

        if(Objects.equals(databaseUser.getPassword(), user.getPassword())){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public boolean deleteUser(Long userId){

        Users entity= userDao.deleteById();
        userDao.delete(entity);
        return true;
    }

}
