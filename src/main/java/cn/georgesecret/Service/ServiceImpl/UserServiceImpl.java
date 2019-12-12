package cn.georgesecret.Service.ServiceImpl;

import cn.georgesecret.Service.UserService;
import cn.georgesecret.entity.User;
import cn.georgesecret.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

}
