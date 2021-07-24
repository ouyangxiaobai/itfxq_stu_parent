package cn.itfxq.common.domain;

import lombok.Data;

/**
 * @description: TODO
 * @author: xxx

 * @datetime: 2020/7/1 16:57
 */
@Data
public class Score extends BaseEntity {
    private Long userid;//学生id
    private SysUser user;//学生用户
    private String score;//得分
    private Long courseid;//课程号
    private Course course;//课程实体对象
}
