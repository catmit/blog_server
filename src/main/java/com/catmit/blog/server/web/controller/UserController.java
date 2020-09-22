package com.catmit.blog.server.web.controller;

import com.catmit.blog.server.web.model.po.UserPO;
import com.catmit.blog.server.web.model.vo.Page;
import com.catmit.blog.server.web.model.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {

    @PostMapping("/login")
    public UserVO login(@RequestParam UserPO user){
        return new UserVO();
    }

    @PostMapping("/register")
    public UserVO register(@RequestParam UserPO user){
        return new UserVO();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable int userId){

    }

    @GetMapping("/{userId}")
    public UserVO getUserById(@PathVariable int userId){
        return new UserVO();
    }

    @GetMapping("/users?offset={offset}&limit={limit}")
    public Page<UserVO> listUsers(@PathVariable int offset, @PathVariable int limit){
        return new Page.PageBuilder<UserVO>().offset(offset).limit(limit).build();
    }


}
