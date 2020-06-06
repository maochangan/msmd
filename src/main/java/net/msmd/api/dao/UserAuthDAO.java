package net.msmd.api.dao;

import net.msmd.api.bean.bo.LoginUserBO;
import net.msmd.api.bean.vo.LoginUserVO;
import org.apache.ibatis.annotations.Param;

public interface UserAuthDAO {

    public LoginUserBO findUserByAccountAndPassword(LoginUserVO loginUser);

    public LoginUserBO findUserById(@Param("id") int id);
}
