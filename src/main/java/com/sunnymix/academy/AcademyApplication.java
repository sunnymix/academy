package com.sunnymix.academy;

import com.sunnymix.academy.user.dao.UserData;
import com.sunnymix.academy.user.dao.UserDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@SpringBootApplication
@RestController
public class AcademyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcademyApplication.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "Welcome to Academy.";
    }

    @Autowired
    private UserDataRepo userDataRepo;

    @GetMapping("/user/{id}")
    public String userName(@PathVariable Long id) {
        Optional<UserData> userPo = userDataRepo.findById(id);
        return userPo.map(UserData::getName).orElse("unknown");
    }

}
