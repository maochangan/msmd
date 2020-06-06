package net.msmd.api.server.impl;

import net.msmd.api.bean.bo.UserInfoBO;
import net.msmd.api.bean.vo.UserInfoVO;
import net.msmd.api.dao.UserInfoDAO;
import net.msmd.api.server.UserInfoService;
import net.msmd.api.util.SerResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class UserInfoServerImpl implements UserInfoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public SerResult<UserInfoBO> getUserInfoById(UserInfoVO userInfo) {
        try {
            UserInfoBO result = userInfoDAO.findUserInfoById(userInfo);
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
