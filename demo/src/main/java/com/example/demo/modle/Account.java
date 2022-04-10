package com.example.demo.modle;

import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Accounts")

public class Account {

    @Id
    @SequenceGenerator( name = "userSeq", sequenceName = "user_id",
            allocationSize = 1, initialValue = 1 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "userSeq")
    @Column(name = "id")
    private Long id;
    @Column(name = "account")
    private String account;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    public Account() {

    }
    public Account(
                   Long id,
                   String account,
                   String password,
                   String name) {
        this.account = account;
        this.password = password;
        this.name = name;
    }



    public Long getId() {

        return id;
    }
    public void setId(Long id) {
        this.id = id;

    }
    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }



}
