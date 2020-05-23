package com.o2o.pn.web.local;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/local")
public class LocalController {
        /*
        *
        * 账号绑定页面路由
        * */
        @RequestMapping(value = "/accountbind",method = RequestMethod.GET)
        private String accountbind(){
            return "local/accountbind";
        }
        /*
        * 修改密码页路由
        *
        * */
        @RequestMapping(value = "/changepsw",method = RequestMethod.GET)
        private String changepsw(){
            return "local/changepsw";
        }

        /*
        * 登录页面路由
        * */
        @RequestMapping(value = "/login",method = RequestMethod.GET)
        private String login(){
            return "local/login";
        }
}
