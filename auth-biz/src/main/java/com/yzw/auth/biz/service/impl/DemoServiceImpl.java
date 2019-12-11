package com.yzw.auth.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yzw.auth.biz.service.DemoService;
import com.yzw.auth.dao.entity.UserDO;
import com.yzw.auth.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// +----------------------------------------------------------------------
// | 广西西途比网络科技有限公司 www.c2b666.com
// +----------------------------------------------------------------------
// | 功能描述: 请输入描述
// +----------------------------------------------------------------------
// | 时　　间: 2019/11/26 19:54
// +----------------------------------------------------------------------
// | 代码创建: 姚政旺 <1402205524@qq.com>
// +----------------------------------------------------------------------
// | 版本信息: V1.0.0
// +----------------------------------------------------------------------
// | 代码修改:
// +----------------------------------------------------------------------
@Service
public class DemoServiceImpl extends ServiceImpl<UserMapper, UserDO> implements DemoService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String test() {
        UserDO user = userMapper.getById();
        return user.toString();
    }
}
