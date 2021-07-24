package cn.itfxq.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: soulcoder
 * @datetime: 2020/6/18 16:13
 * @description: TODO
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = -5604007880179803027L;

    private Long id;

    private String username;


    private String password;
    /**
     * 头像
     */

    private String icon;
    /**
     * 邮箱
     */

    private String email;
    /**
     * 电话
     */
    private String tel;

    /**
     * 昵称
     */

    private String nickName;

    /**
     * 备注信息
     */

    private String note;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    private Date createTime;

    /**
     * 最后登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    private Date loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    private Integer status;

    //用户对应的角色
    private List<SysRole> userRolesList = new ArrayList();

    private Boolean sex;
    private Integer type; //type=1 是管理员  type=2是老师 type=3是学生
    private String stunum;//学生学号
    //班级id
    private Long classesid;
    //学生所属班级
    private Classes classes;
    //学生选课信息
    private Long courseid;
    //学生选课
    private Course course;
    //学生地址
    private String address;
}
