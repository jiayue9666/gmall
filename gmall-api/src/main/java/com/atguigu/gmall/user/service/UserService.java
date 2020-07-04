package com.atguigu.gmall.user.service;



import com.atguigu.gmall.beans.UmsMember;
import com.atguigu.gmall.beans.UmsMemberReceiveAddress;

import java.util.List;

/**
 * Created by jiayu on 2020/6/29.
 */
public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceivgetReceiveAddressByMemberId(String memberId);
}
