package cn.itfxq.admin.config;


import cn.itfxq.admin.config.jwtfilter.JWTAuthenticationFilter;
import cn.itfxq.admin.config.jwtfilter.JWTLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * spring Security配置安全控制中心

 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 依赖注入自定义的登录成功处理器
     */
    @Autowired
    private LgAuthSuccessHandler lgAuthSuccessHandler;
    /**
     * 依赖注入自定义的登录失败处理器
     */
    @Autowired
    private LgAuthFailureHandler lgAuthFailureHandler;
    /**
     * 依赖注入自定义的注销成功的处理器
     */
    @Autowired
    private LgLogoutSuccessHandler lgLogoutSuccessHandler;
    /**
     * 注册没有权限的处理器
     */
    @Autowired
    private RestAuthAccessDeniedHandler restAuthAccessDeniedHandler;

    /***注入自定义的CustomPermissionEvaluator*/
//    @Bean
//    public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
//        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
//        handler.setPermissionEvaluator(new CustomPermissionEvaluator());
//        return handler;
//    }

    /***注入我们自己的登录逻辑验证器AuthenticationProvider*/
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这里可启用我们自己的登陆验证逻辑
        auth.authenticationProvider(authenticationProvider);
    }

    /**
     * 需要放行的URL
     */
    private static final String[] AUTH_WHITELIST = {
            // -- register url
            "/login",
            "/fileUpload",
            "/static/**",
            "/static/newsImg/**",
            "/upload/**",
            "/favicon.ico",
            // -- 前台放行
            "/user/file/uploadFile",
            "/news/file/uploadFile",
            "/course/file/uploadVideo",
            "/course/showVideo",
            "/user/regUser",
            "/common/queryClasses",
            // -- app放行路径
            "/news/getAllNewsList",
            "/news/showimage",
            "/news/getNewsDetail/*",
            "/score/queryCourses",
            "/score/queryScores",
            "/leave/saveLeave",
            "/leave/queryMyLeave",
            // -- swagger ui
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
            // other public endpoints of your API may be appended to this array
    };

    /**
     * 配置spring security的控制逻辑
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .anyRequest().authenticated()   //其他的需要登陆后才能访问
                .and()
                .formLogin()
                //loginProcessingUrl用于指定前后端分离的时候调用后台登录接口的名称
                .loginProcessingUrl("/login")
                //配置登录成功的自定义处理类
                //.successHandler(lgAuthSuccessHandler)
                //配置登录失败的自定义处理类
                .failureHandler(lgAuthFailureHandler)
                .and()
                //loginProcessingUrl用于指定前后端分离的时候调用后台注销接口的名称
                .logout().logoutUrl("/logout")
                .logoutSuccessHandler(lgLogoutSuccessHandler)
                .and()
                //前后端分离采用JWT 不需要session
               .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //配置没有权限的自定义处理类
                .exceptionHandling().accessDeniedHandler(restAuthAccessDeniedHandler)
                .and()
                //添加JWT过滤器 除已配置的其它请求都需经过此过滤器
                .addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                //  开启跨域
                .cors()
                .and() // 开启 csrf
                .csrf()
                .disable();

                // 取消跨站请求伪造防护

               //配置自定义过滤器 增加post json 支持
                //http.addFilterAt(UserAuthenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }

    private UserAuthenticationFilter UserAuthenticationFilterBean() throws Exception {
        UserAuthenticationFilter userAuthenticationFilter = new UserAuthenticationFilter();
        userAuthenticationFilter.setAuthenticationManager(super.authenticationManager());
        userAuthenticationFilter.setAuthenticationSuccessHandler(lgAuthSuccessHandler);
        return userAuthenticationFilter;
    }
}
