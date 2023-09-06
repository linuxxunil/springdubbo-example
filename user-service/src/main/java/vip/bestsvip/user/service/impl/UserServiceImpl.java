package vip.bestsvip.user.service.impl;


import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vip.bestsvip.api.dto.UserDto;
import vip.bestsvip.api.service.UserService;
import vip.bestsvip.user.entity.User;
import vip.bestsvip.user.repository.UserRepository;

@DubboService
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDto queryById(Long id) {
        User user = userRepository.findById(id).get();
        UserDto userDto = new UserDto();
        if ( user != null ) {
            userDto.setId(user.getId());
            userDto.setAddress(user.getAddress());
            userDto.setUsername(user.getUsername());
        }
        return userDto;
    }

    @Override
    public String helloDubbo() {
       return "HelloDubbo";
    }
}