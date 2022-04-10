package com.example.demo.dao;

import com.example.demo.modle.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;
import java.util.List;

public interface Accountdao extends JpaRepository<Account, Long>{

    @Modifying
    @Query(value = "update Accounts set name= #{name}, password= #{password} where account= #{account}", nativeQuery = true)
    void updateByAccount(Account account);

    @Modifying
    @Query(value = "insert into Accounts values (#{account},#{password},#{name})", nativeQuery = true)
    int add(Account accounttemp);

    Account findByname(String name);
    Account findByAccount(String account);
    Account findAccountById(Long id);
}
