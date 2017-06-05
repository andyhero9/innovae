package com.innovae.service.imp;

import com.innovae.domain.UserDomain;
import com.innovae.model.User;
import com.innovae.repository.AccountRepository;
import com.innovae.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Polotin on 2017/5/19.
 */
@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public String loginWithPwd(User user){
        String userName = "";
        try{
            List<User> users= accountRepository.validAccountWhenLoggin(user.getId(), user.getPassword());
            if(users.size() == 0){
                return userName;
            }else {
                //Login success
                userName = users.get(0).getName();
                return userName;
            }
        }catch (Exception e){
            throw e;
        }
    }
    @Override
    public UserDomain UserLogin(User user)throws Exception{
        UserDomain userDomain;
        String userName = loginWithPwd(user);
        //login success
        if(userName != null && userName != ""){
            userDomain = new UserDomain(0, user.getId(), userName);
        }else {
            userDomain = new UserDomain(1, user.getId(), userName);
        }
        return userDomain;
    }
}
