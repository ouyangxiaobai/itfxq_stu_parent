package cn.itfxq.admin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyPicConfigurer implements WebMvcConfigurer {

    @Value("${newsfile.upload.path}")
    private String filePath; // 本地路径 localPath

    @Value("${file.upload.path}")
    private String userFilePath;
	


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/newsImg/**").addResourceLocations("file:" + filePath+"\\");
        registry.addResourceHandler("/static/upload/**").addResourceLocations("file:" + userFilePath+"\\");
    }
}