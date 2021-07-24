package cn.itfxq.admin;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Set;

//登录用户封装
public class UserSecurity extends User {

    cn.itfxq.common.domain.SysUser loginUser;
    private String token;

    public UserSecurity(cn.itfxq.common.domain.SysUser user, Set<GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(),true,true,true,true, authorities);
        this.loginUser = user;
    }

    public cn.itfxq.common.domain.SysUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(cn.itfxq.common.domain.SysUser loginUser) {
        this.loginUser = loginUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
