package net.msmd.api.dao;

import net.msmd.api.bean.bo.UserInfoBO;
import net.msmd.api.bean.vo.UserInfoVO;

public interface UserInfoDAO {

    public UserInfoBO findUserInfoById(UserInfoVO userInfo);

}
