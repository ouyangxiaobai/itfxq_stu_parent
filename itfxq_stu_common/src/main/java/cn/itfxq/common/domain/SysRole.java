package cn.itfxq.common.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: soulcoder
 * @datetime: 2020/6/17 19:48
 * @description: 角色
 */
@Data
public class SysRole {

    private Long id;//角色id
    private String name;//角色名称
    private String enname;//角色编号
    private Integer roleType;//角色类型
    private Integer dataScope;//数据范围
    private Long createBy;
    private Date createDate;
    private Long updateBy;
    private Date updateDate;
    //角色对应的菜单
    private List<SysMenu> menuList = new ArrayList<>();
}
