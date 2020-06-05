package net.msmd.api.server;

import net.msmd.api.bean.LoginUser;
import net.msmd.api.bean.UserInfo;
import net.msmd.api.util.SerResult;

public interface LoginUserServer {

    public LoginUser findUserById(int parseInt);

    public SerResult<UserInfo> userLogin(LoginUser loginUser);
}
