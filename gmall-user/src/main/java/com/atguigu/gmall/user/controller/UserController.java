package com.atguigu.gmall.user.controller;


import com.atguigu.gmall.beans.UmsMember;
import com.atguigu.gmall.beans.UmsMemberReceiveAddress;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by jiayu on 2020/6/29.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;



    @RequestMapping("index")
    @ResponseBody
    public String demo(){
        return "hello8080";
    }


    @RequestMapping("getReceiveAddresByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId){
        List<UmsMemberReceiveAddress> umsMembers=userService.getReceivgetReceiveAddressByMemberId(memberId);
        return umsMembers;
    }

    @RequestMapping("getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
        List<UmsMember> umsMembers=userService.getAllUser();
        return umsMembers;
    }
}
