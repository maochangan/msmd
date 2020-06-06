package net.msmd.api.util.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import net.msmd.api.bean.bo.LoginUserBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class TokenServerImpl implements TokenServer {

    @Override
    public String getToken(LoginUserBO user) {
        Date expiresAt = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
        String token = "";
        token = JWT.create().withAudience(user.getId().toString()).withExpiresAt(expiresAt).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    @Override
    public String refreshToken(String token) {
        return null;
    }

    @Override
    public boolean tokenBeRefreshed(String token, Date date) {
        return false;
    }
}
