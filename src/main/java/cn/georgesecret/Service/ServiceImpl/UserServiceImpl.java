package cn.georgesecret.Service.ServiceImpl;

import cn.georgesecret.Service.UserService;
import cn.georgesecret.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;


public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

}
