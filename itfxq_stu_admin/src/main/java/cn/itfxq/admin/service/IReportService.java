package cn.itfxq.admin.service;



import cn.itfxq.admin.dto.MyReportVo;
import cn.itfxq.admin.dto.ReportVo;

import java.util.List;

/**
 * @description: 报表Service层
 * @author: xxx

 * @datetime: 2020/7/1 18:31
 */
public interface IReportService {
    //课程平均分报表
    List<ReportVo> courseAvgReport();

    //每个课程成绩 myScoreReport
    List<MyReportVo> myScoreReport(Long userid);
}
