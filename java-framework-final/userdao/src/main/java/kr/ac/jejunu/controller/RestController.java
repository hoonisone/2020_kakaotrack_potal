package kr.ac.jejunu.controller;

import kr.ac.jejunu.database.object.User;
import kr.ac.jejunu.database.dao.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.AbstractDocument;
import java.io.File;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class RestController {
    private final UserDao userDao;

    @GetMapping("/{id}")
    public User get(@PathVariable("id") String id){
        return userDao.get(id);
    }


    public User create(@RequestBody User user){
        userDao.insert(user);
        return user;
    }
}
