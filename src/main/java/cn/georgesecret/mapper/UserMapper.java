package cn.georgesecret.mapper;

import cn.georgesecret.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<User> queryUserList();
}

