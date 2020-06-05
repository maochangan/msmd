package net.msmd.api.util.token;

import net.msmd.api.bean.UserInfo;

import java.util.Date;

public interface TokenServer {

    public String getToken(UserInfo user);

    public String refreshToken(String token);

    public boolean tokenBeRefreshed(String token, Date date);

}
