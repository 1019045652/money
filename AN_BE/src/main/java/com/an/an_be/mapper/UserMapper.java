package com.an.an_be.mapper;

import com.an.an_be.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User findUser(User user);
}
