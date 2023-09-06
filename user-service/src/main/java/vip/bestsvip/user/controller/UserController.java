package vip.bestsvip.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vip.bestsvip.api.dto.UserDto;
import vip.bestsvip.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
 
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public UserDto queryUserByUserId(@PathVariable("userId") Long userId) {
        // 根据id查询订单并返回
        return userService.queryById(userId);
    }

    @GetMapping("/hello")
    public String hello() {
        // 根据id查询订单并返回
        return userService.helloDubbo();
    }
}
