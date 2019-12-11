package com.yzw.auth.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

// +----------------------------------------------------------------------
// | 广西西途比网络科技有限公司 www.c2b666.com
// +----------------------------------------------------------------------
// | 功能描述: 请输入描述
// +----------------------------------------------------------------------
// | 时　　间: 2019/11/26 19:36
// +----------------------------------------------------------------------
// | 代码创建: 姚政旺 <1402205524@qq.com>
// +----------------------------------------------------------------------
// | 版本信息: V1.0.0
// +----------------------------------------------------------------------
// | 代码修改:
// +----------------------------------------------------------------------
@SpringBootApplication(scanBasePackages = "com.yzw")
@MapperScan("com.yzw.auth.dao.mapper")
@EnableAuthorizationServer
public class AuthWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthWebApplication.class, args);
    }
}
