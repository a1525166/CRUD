package com.example.demo.Service;

import com.example.demo.dao.Accountdao;
import com.example.demo.modle.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    Accountdao accountdao;

    //public List<String> Verify(){
        //return  accountdao.account();
   // }

    public void addAccount(Account accounttemp){
        accountdao.save(accounttemp);
    }

    public void deletePersonById(Long id){
        accountdao.deleteById((long) id);
    }

    public Account findByaccount(String account){
        return accountdao.findByAccount(account);
    }

    public List<Account> getAllAccount(){

        return  accountdao.findAll();
    }

    public Account findAccountById(Long id){

        return accountdao.findAccountById(id);
    }

    public void updateByAccount(Account account){
        accountdao.updateByAccount(account);

    }

    public Account findByName(String name){

        return accountdao.findByname(name);
    }
}
