package net.msmd.api.util.token;

import net.msmd.api.bean.bo.LoginUserBO;

import java.util.Date;

public interface TokenServer {

    public String getToken(LoginUserBO user);

    public String refreshToken(String token);

    public boolean tokenBeRefreshed(String token, Date date);

}
