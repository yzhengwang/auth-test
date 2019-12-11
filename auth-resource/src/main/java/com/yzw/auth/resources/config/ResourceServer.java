package com.yzw.auth.resources.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

// +----------------------------------------------------------------------
// | 广西西途比网络科技有限公司 www.c2b666.com
// +----------------------------------------------------------------------
// | 功能描述: 请输入描述
// +----------------------------------------------------------------------
// | 时　　间: 2019/12/11 15:53
// +----------------------------------------------------------------------
// | 代码创建: 姚政旺 <1402205524@qq.com>
// +----------------------------------------------------------------------
// | 版本信息: V1.0.0
// +----------------------------------------------------------------------
// | 代码修改:
// +----------------------------------------------------------------------
@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {

    private static final String[] ignoreMatchers = {
            "/oauth/**"
    };

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers(ignoreMatchers)
                .permitAll()
                .anyRequest()
                .authenticated();
    }
}
