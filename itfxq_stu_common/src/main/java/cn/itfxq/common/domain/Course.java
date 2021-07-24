package cn.itfxq.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author: soulcoder-项目库分享圈
 * @datetime: 2020/7/1 8:34

 * @description: 课程列表
 */
@Data
public class Course {
    //课程编号
    private Long id;
    //课程名称
    private String name;
    //课程老师的编号
    private Long tid;

    //课程所属老师
    private SysUser user;
    //创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    //视频介绍地址
    private String videoUrl;
}
