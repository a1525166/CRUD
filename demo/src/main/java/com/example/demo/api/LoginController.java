package com.example.demo.api;

import com.example.demo.Service.LoginService;
import com.example.demo.modle.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("Login")
    public String Login(Model model){
        //List<String> list = loginService.Verify();
        //model.addAttribute("a", list);

        Account accounttemp = new Account();
        model.addAttribute("accounttemp", accounttemp);

        String account = new String();
        model.addAttribute("account", account);

        return "Login";
    }

    @Transactional
    @RequestMapping("/Verify")
    @PostMapping
    public String Verify(Account accounttemp) {
        String a;
        Account accountdata = loginService.findByaccount(accounttemp.getAccount());
        if(accountdata.getPassword() == accounttemp.getPassword()) {
            a = "redirect:/Register";
        }else {
            a =  "redirect:/index1";
        }
        return a;
    }

    @PostMapping("/add")
    public String addAccount(Account accounttemp) {
        loginService.addAccount(accounttemp);
        return "index1";
    }

    @RequestMapping("/delete")
    @DeleteMapping
    public String deletePersonById(Long id){
        loginService.deletePersonById(id);
        return "redirect:/index1";
    }

    @PostMapping("/find")
    public String findByAccount(Model model, String account){
        Account account1 =  loginService.findByaccount(account);
        model.addAttribute("accounttemp", account1 );
        return "find";
    }


    @RequestMapping("/update")
    @PostMapping
    public String updatePersonById(Account account) {
        loginService.addAccount(account);
        return "redirect:/index1";
    }
}
