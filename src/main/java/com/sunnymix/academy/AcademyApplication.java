package com.sunnymix.academy;

import com.sunnymix.academy.user.dao.UserPo;
import com.sunnymix.academy.user.dao.UserPoDao;
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
    private UserPoDao userPoDao;

    @GetMapping("/user/{id}")
    public String userName(@PathVariable Long id) {
        Optional<UserPo> userPo = userPoDao.findById(id);
        return userPo.map(UserPo::getName).orElse("unknown");
    }

}
