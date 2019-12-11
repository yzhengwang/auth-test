package com.yzw.auth.web.controller;

import com.yzw.auth.biz.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.Thymeleaf;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
@Controller
@SessionAttributes("authorizationRequest")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("test")
    public String test() {
        return demoService.test();
    }

    @GetMapping("/auth/login")
    public String loginPage(Model model) {
        model.addAttribute("loginProcessUrl", "/auth/authorize");
        return "base-login";
    }

    @RequestMapping("/custom/confirm_access")
    public ModelAndView getAccessConfirmation(Map<String, Object> model, HttpServletRequest request) throws Exception {
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) model.get("authorizationRequest");
        ModelAndView view = new ModelAndView();
        view.setViewName("base-grant");
        view.addObject("clientId", authorizationRequest.getClientId());
        view.addObject("scopes", authorizationRequest.getScope());
        return view;
    }
}
