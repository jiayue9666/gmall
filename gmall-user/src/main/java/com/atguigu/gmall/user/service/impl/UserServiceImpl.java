package com.atguigu.gmall.user.service.impl;


import com.atguigu.gmall.beans.UmsMember;
import com.atguigu.gmall.beans.UmsMemberReceiveAddress;
import com.atguigu.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.atguigu.gmall.user.mapper.UserMapper;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by jiayu on 2020/6/29.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;
    @Override
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMembers=userMapper.selectAll();
        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceivgetReceiveAddressByMemberId(String memberId) {
       /* Example e=new Example(UmsMemberReceiveAddress.class);
        e.createCriteria().andEqualTo("memberId",memberId);*/
       UmsMemberReceiveAddress umsMemberReceiveAddress=new UmsMemberReceiveAddress();
       umsMemberReceiveAddress.setMemberId(memberId);
       //根据不为空的字段来查询相关的数据
       List<UmsMemberReceiveAddress> list= umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
       return list;
    }
}
