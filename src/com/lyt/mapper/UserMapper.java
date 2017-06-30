package com.lyt.mapper;

import java.util.List;  

import com.lyt.model.User;  
/** 
 * 做为 DAO的接口 
 * @author */  
public interface UserMapper {    
    int save(User user);    
    int update(User user);    
    int delete(int id);    
    User findById(int id);    
    List<User> findAll();    
} 
