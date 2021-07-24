package cn.itfxq.auth.config.util;

import cn.itfxq.auth.config.constant.ConstantKey;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.http.HttpServletRequest;

public class LgUtils {

    public static Long getLoginUserId(HttpServletRequest request){
        String authorization = request.getHeader("Authorization");
        Claims claims = Jwts.parser()
                .setSigningKey(ConstantKey.SIGNING_KEY)
                .parseClaimsJws(authorization.replace("Bearer ", "")).getBody();
        String userId=claims.getId();
        return Long.parseLong(userId);
    }
}
