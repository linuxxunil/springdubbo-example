package vip.bestsvip.api.service;

import vip.bestsvip.api.dto.UserDto;

/**
 * 宣告接口
 */
public interface UserService { 
    public UserDto queryById(Long id);

    public String helloDubbo() ;
}