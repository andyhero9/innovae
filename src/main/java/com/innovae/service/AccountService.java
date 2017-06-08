package com.innovae.service;

import com.innovae.domain.UserDomain;
import com.innovae.model.User;
import org.springframework.stereotype.Service;

/**
 * @author 张志强
 * @version v0.1 2017/6/4.
 */
public interface AccountService {
    String loginWithPwd(User user);
    UserDomain UserLogin(User user)throws Exception;

    String register(User user);
    UserDomain UserRegister(User user)throws  Exception;
}
