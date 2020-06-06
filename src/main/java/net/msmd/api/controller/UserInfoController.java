package net.msmd.api.controller;

import net.msmd.api.bean.bo.UserInfoBO;
import net.msmd.api.bean.vo.UserInfoVO;
import net.msmd.api.server.UserInfoService;
import net.msmd.api.util.JsonResult;
import net.msmd.api.util.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("info")
    public JsonResult getUserInfo(@Validated UserInfoVO userInfo){
        try {
            SerResult<UserInfoBO> result = userInfoService.getUserInfoById(userInfo);
            if (result.isSuccess()) {
                return JsonResult.success().add("info" , result.getValue());
            }else{
                return JsonResult.fail();
            }
        } catch (Exception e) {
            logger.error("e" + e.getMessage());
            return JsonResult.error();
        }
    }

}
