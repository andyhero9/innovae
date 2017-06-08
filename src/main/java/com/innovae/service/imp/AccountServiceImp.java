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
        try{
            User user1 = accountRepository.findOne(user.getId());
            return user1.getName();
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
            userDomain = new UserDomain(1, user.getId(), userName);
        }else {
            userDomain = new UserDomain(0, user.getId(), userName);
        }
        return userDomain;
    }

    @Override
    public String register(User user){
        try{
            accountRepository.save(user);
            User user1 = accountRepository.findOne(user.getId());
            return user1.getName();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public UserDomain UserRegister(User user) throws Exception{
        UserDomain userDomain;
        String userName = register(user);
        //reg success
        if(userName != null && userName != ""){
            userDomain = new UserDomain(1, user.getId(), userName);
        }else {
            userDomain = new UserDomain(0, user.getId(), userName);
        }
        return userDomain;
    }
}
