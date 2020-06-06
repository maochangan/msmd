package net.msmd.api.controller;

import net.msmd.api.bean.bo.LoginUserBO;
import net.msmd.api.bean.vo.LoginUserVO;
import net.msmd.api.server.UserAuthServer;
import net.msmd.api.util.JsonResult;
import net.msmd.api.util.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*" , maxAge = 3600)
@RestController
@RequestMapping(value = "/auth")
public class UserAuthController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserAuthServer userAuthServer;

    @PostMapping("/login")
    public JsonResult loginMethod(@Validated LoginUserVO loginUser){
        try {
            if (StringUtils.isEmpty(loginUser)) {
                return JsonResult.fail().add("msg", "please check your account");
            }
            SerResult<LoginUserBO> result = userAuthServer.loginMethod(loginUser);
            if(result.isSuccess()){
                return null;
            }else{
                return null;
            }

        } catch (Exception e) {
            logger.error("e" + e.getMessage());
            return JsonResult.error();
        }
    }






}
