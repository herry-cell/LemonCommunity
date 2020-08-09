package com.sgldts.community.service;

import com.sgldts.community.mapper.UserMapper;
import com.sgldts.community.model.User;
import com.sgldts.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author herry
 * @create 2020-08-09-18:08
 */

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() != 0) {
            user.setGmtModified(System.currentTimeMillis());
            UserExample example = new UserExample();
            example.createCriteria()
                    .andAccountIdEqualTo(user.getAccountId());
            userMapper.updateByExample(user, example);
        } else {
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }
    }
}
