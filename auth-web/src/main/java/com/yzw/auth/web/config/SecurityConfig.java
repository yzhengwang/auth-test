package com.yzw.auth.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// +----------------------------------------------------------------------
// | 广西西途比网络科技有限公司 www.c2b666.com
// +----------------------------------------------------------------------
// | 功能描述: 配置spring security
// +----------------------------------------------------------------------
// | 时　　间: 2019/12/11 11:00
// +----------------------------------------------------------------------
// | 代码创建: 姚政旺 <1402205524@qq.com>
// +----------------------------------------------------------------------
// | 版本信息: V1.0.0
// +----------------------------------------------------------------------
// | 代码修改:
// +----------------------------------------------------------------------
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 配置这个bean会在做AuthorizationServerConfigurer配置的时候使用
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 配置用户
     * 使用内存中的用户，实际项目中，一般使用的是数据库保存用户，具体的实现类可以使用JdbcDaoImpl或者JdbcUserDetailsManager
     *
     * @return
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin").password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin")).authorities("USER").build());
        return manager;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        // 设置默认的加密方式
//        return new BCryptPasswordEncoder();
//    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        // 将 check_token 暴露出去，否则资源服务器访问时报 403 错误
//        web.ignoring().antMatchers("/oauth/check_token");
//    }

/*    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                // 必须配置，不然OAuth2的http配置不生效----不明觉厉
                .requestMatchers()
                .antMatchers("/auth/login", "/auth/authorize", "/oauth/authorize")
                .and()
                .authorizeRequests()
                // 自定义页面或处理url是，如果不配置全局允许，浏览器会提示服务器将页面转发多次
                .antMatchers("/auth/login", "/auth/authorize")
                .permitAll()
                .anyRequest()
                .authenticated();

        // 表单登录
        http.formLogin()
                // 登录页面
                .loginPage("/auth/login")
                // 登录处理url
                .loginProcessingUrl("/auth/authorize");
        http.httpBasic().disable();
    }*/
}
