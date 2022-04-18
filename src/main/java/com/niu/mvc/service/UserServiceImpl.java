package com.niu.mvc.service;

import com.niu.jpa.dao.UserDao;
import com.niu.jpa.entity.RoleDO;
import com.niu.jpa.entity.UserDO;
import com.niu.mvc.dto.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * UserServiceImpl
 *
 * @author [nza]
 * @createTime [2022/04/18 22:56]
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDO save(UserRegistration registrationDto) {
        UserDO user = new UserDO(registrationDto.getEmail(), registrationDto.getFirstName(), registrationDto.getLastName(),
                passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new RoleDO("ROLE_USER")));

        return userDao.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDO userDO = userDao.findByEmail(username);
        if (username == null) {
            throw new UsernameNotFoundException("user not found");
        }
        return new User(userDO.getEmail(), userDO.getPassword(), mapRolesToAuthorities(userDO.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleDO> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
