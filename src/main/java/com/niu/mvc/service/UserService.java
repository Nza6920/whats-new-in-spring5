package com.niu.mvc.service;

import com.niu.jpa.entity.UserDO;
import com.niu.mvc.dto.UserRegistration;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * UserService
 *
 * @author [nza]
 * @createTime [2022/04/18 22:55]
 */
public interface UserService extends UserDetailsService {

    UserDO save(UserRegistration registrationDto);

}
