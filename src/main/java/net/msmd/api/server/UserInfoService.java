package net.msmd.api.server;

import net.msmd.api.bean.bo.UserInfoBO;
import net.msmd.api.bean.vo.UserInfoVO;
import net.msmd.api.util.SerResult;

public interface UserInfoService {

    public SerResult<UserInfoBO> getUserInfoById(UserInfoVO userInfo);
}
