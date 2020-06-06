package net.msmd.api.server.impl;

import net.msmd.api.bean.bo.LoginUserBO;
import net.msmd.api.bean.vo.LoginUserVO;
import net.msmd.api.dao.UserAuthDAO;
import net.msmd.api.server.UserAuthServer;
import net.msmd.api.util.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserAuthServerImpl implements UserAuthServer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserAuthDAO userAuthDAO;

    @Override
    public SerResult<LoginUserBO> loginMethod(LoginUserVO loginUser) {
        try {
            LoginUserBO result = userAuthDAO.findUserByAccountAndPassword(loginUser);
            if(null == result){
                return SerResult.createFail();
            }else{
                return SerResult.createSuccess(result);
            }
        } catch (Exception e) {
            logger.error("e" + e.getMessage());
            return SerResult.createError();
        }
    }
}
