package com.lyt.service.impl;

import java.util.List;  

import javax.annotation.Resource;  
  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  
  
import com.lyt.mapper.UserMapper;  
import com.lyt.model.User;  
import com.lyt.service.impl.UserService;  
 
@Service  
@Transactional  
// �˴����ٽ��д���SqlSession���ύ���񣬶��ѽ���springȥ�����ˡ�  
public class UserServiceImpl implements UserService {  
 
    @Resource  
    private UserMapper mapper;  
  
    /**  
     * ����  id  ɾ�� ����  
     */  
    public int delete(int id) {  
         return mapper.delete(id);
    }  
    /**  
     * ��ѯUser��ȫ������  
     */  
    public List<User> findAll() {  
        List<User> findAllList = mapper.findAll();  
        return findAllList;  
    }  
    /**  
     * ���� id ��ѯ ��Ӧ����  
     */  
    public User findById(int id) {  
        User user = mapper.findById(id);  
        return user;  
    }  
    /**  
     * ��������  
     */  
    public int save(User user) {  
        return mapper.save(user);  
    }  
    /**  
     * ���� id �޸Ķ�Ӧ����  
     */  
    public int update(User user) {  
         return mapper.update(user);

    }  
  
} 
