package cn.itfxq.common.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Leave extends BaseEntity{

    private Long userid;

    private SysUser user;

    private String username;

    private String day;

    private String leavetime;

    private String content;

    private Long status;

    private Date createTime;

}
