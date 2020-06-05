package net.msmd.api.controller;


import net.msmd.api.bean.LoginUser;
import net.msmd.api.bean.TestBean;
import net.msmd.api.bean.UserInfo;
import net.msmd.api.server.LoginUserServer;
import net.msmd.api.server.TestServer;
import net.msmd.api.util.JsonResult;
import net.msmd.api.util.SerResult;
import net.msmd.api.util.token.TokenServer;
import net.msmd.api.util.token.UserLoginToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TokenServer createToken;

    @Autowired
    private TestServer testServer;

    @Autowired
    private LoginUserServer loginUserServer;


    @GetMapping(value = "/one")
    public JsonResult test(){
        try {
            SerResult<List<TestBean>> result = testServer.getTest();
            if (result.isSuccess()) {
                return JsonResult.success().add("users", result.getValue());
            }else{
                return JsonResult.fail();
            }
        } catch (Exception e) {
            logger.error("" + e.getMessage());
            return JsonResult.error();
        }
    }

    @PostMapping("/login")
    public JsonResult userLogin(LoginUser loginUser) {
        try {
            SerResult<UserInfo> result = loginUserServer.userLogin(loginUser);
            if (result.isSuccess()) {
                String token = createToken.getToken(result.getValue());
                return JsonResult.success().add("token", token);
            }else{
                return JsonResult.fail().add("msg", "请检查账号信息");
            }

        } catch (Exception e) {
            logger.error("e" + e.getMessage());
            return JsonResult.error();
        }
    }

    @UserLoginToken
    @GetMapping("/test")
    public JsonResult testToken(){
        try {
            return JsonResult.success().add("success", "successToken");
        } catch (Exception e) {
            logger.error("e" + e.getMessage());
            return JsonResult.error();
        }
    }



//something change
}
