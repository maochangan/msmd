package net.msmd.api.server;

import net.msmd.api.bean.bo.LoginUserBO;
import net.msmd.api.bean.vo.LoginUserVO;
import net.msmd.api.util.SerResult;

public interface UserAuthServer {

    public SerResult<LoginUserBO> loginMethod(LoginUserVO loginUser);

    public SerResult<LoginUserBO> findUserById(int parseInt);
}
