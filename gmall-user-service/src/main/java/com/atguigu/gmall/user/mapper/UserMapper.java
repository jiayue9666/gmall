package com.atguigu.gmall.user.mapper;



import com.atguigu.gmall.beans.UmsMember;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**命名空间绑定一个mapper接口
 * Created by jiayu on 2020/6/29.
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<UmsMember> {
    List<UmsMember> selectAllUser();
}
