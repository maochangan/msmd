package net.msmd.api.server.impl;

import net.msmd.api.bean.LoginUser;
import net.msmd.api.bean.UserInfo;
import net.msmd.api.dao.LoginUserDAO;
import net.msmd.api.server.LoginUserServer;
import net.msmd.api.util.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class LoginServerImpl implements LoginUserServer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginUserDAO loginUserDAO;


    @Override
    public LoginUser findUserById(int parseInt) {
        try {
            LoginUser loginUser = loginUserDAO.findUserById(parseInt);
            if (StringUtils.isEmpty(loginUser)) {
                return null;
            }else{
                return loginUser;
            }
        } catch (Exception e) {
            logger.error("e" + e.getMessage());
            return null;
        }
    }

    @Override
    public SerResult<UserInfo> userLogin(LoginUser loginUser) {
        try {
            UserInfo result = loginUserDAO.getUser(loginUser);
            if (!StringUtils.isEmpty(result)) {
                return SerResult.createSuccess(result);
            }else{
                return SerResult.createFail();
            }
        } catch (Exception e) {
            logger.error("e" + e.getMessage());
            return SerResult.createError();
        }
    }
}
