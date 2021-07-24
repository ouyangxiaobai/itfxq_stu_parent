package cn.itfxq.admin.dto;

import lombok.Data;


@Data
public class ReportVo {
    //课程名称
    private  String name;

    //课程平均分
    private double avgScore;
}
