package net.msmd.api.dao;

import net.msmd.api.bean.LoginUser;
import net.msmd.api.bean.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface LoginUserDAO {

    public UserInfo getUser(LoginUser loginUser);

    public LoginUser findUserById(@Param("id") int id);
}
