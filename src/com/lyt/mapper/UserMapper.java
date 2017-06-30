package com.lyt.mapper;

import java.util.List;  

import com.lyt.model.User;  
/** 
 * ��Ϊ DAO�Ľӿ� 
 * @author */  
public interface UserMapper {    
    int save(User user);    
    int update(User user);    
    int delete(int id);    
    User findById(int id);    
    List<User> findAll();    
} 
