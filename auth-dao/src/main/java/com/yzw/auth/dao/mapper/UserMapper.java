package com.yzw.auth.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yzw.auth.dao.entity.UserDO;

// +----------------------------------------------------------------------
// | 广西西途比网络科技有限公司 www.c2b666.com
// +----------------------------------------------------------------------
// | 功能描述: 请输入描述
// +----------------------------------------------------------------------
// | 时　　间: 2019/11/26 20:19
// +----------------------------------------------------------------------
// | 代码创建: 姚政旺 <1402205524@qq.com>
// +----------------------------------------------------------------------
// | 版本信息: V1.0.0
// +----------------------------------------------------------------------
// | 代码修改:
// +----------------------------------------------------------------------
public interface UserMapper extends BaseMapper<UserDO> {

    UserDO getById();
}
