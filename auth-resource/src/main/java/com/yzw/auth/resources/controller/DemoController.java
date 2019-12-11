package com.yzw.auth.resources.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// +----------------------------------------------------------------------
// | 广西西途比网络科技有限公司 www.c2b666.com
// +----------------------------------------------------------------------
// | 功能描述: 请输入描述
// +----------------------------------------------------------------------
// | 时　　间: 2019/11/26 19:38
// +----------------------------------------------------------------------
// | 代码创建: 姚政旺 <1402205524@qq.com>
// +----------------------------------------------------------------------
// | 版本信息: V1.0.0
// +----------------------------------------------------------------------
// | 代码修改:
// +----------------------------------------------------------------------
@RestController
@RequestMapping("demo")
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    // 添加一个测试访问接口
    @GetMapping("user")
    @Scope(value = "test")
    public Authentication getUser(Authentication authentication) {
        log.info("resource: user {}", authentication);
        return authentication;
    }
}
