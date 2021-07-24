package cn.itfxq.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @description: 新闻类
 * @author: xxx

 * @datetime: 2020/7/4 17:56
 */
@Data
public class News {

    //新闻id
    private Long id;

    //新闻title
    private String title;

    //content 新闻内容
    private String content;

    //fmUrl 封面图
    private String fmUrl;

    //createTime 创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    //用户id
    private Long userid;

    private SysUser user;
}
