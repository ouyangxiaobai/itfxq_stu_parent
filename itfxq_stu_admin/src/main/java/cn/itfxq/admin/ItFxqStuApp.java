package cn.itfxq.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description:学生后台服务启动
 * @author:

 */
@SpringBootApplication(scanBasePackages = "cn.itfxq.admin")
@MapperScan("cn.itfxq.admin.mapper")
public class ItFxqStuApp {

    public static void main(String[] args) {
        SpringApplication.run(ItFxqStuApp.class, args);
    }
    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
