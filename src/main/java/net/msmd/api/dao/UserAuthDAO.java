package net.msmd.api.dao;

import net.msmd.api.bean.bo.LoginUserBO;
import net.msmd.api.bean.vo.LoginUserVO;

public interface UserAuthDAO {

    public LoginUserBO findUserByAccountAndPassword(LoginUserVO loginUser);
}
