package cn.itfxq.admin.mapper;



import cn.itfxq.admin.dto.MyReportVo;
import cn.itfxq.admin.dto.ReportVo;

import java.util.List;


public interface ReportMapper {

    //课程平均分报表
    List<ReportVo> courseAvgReport();

    //每个课程成绩 myScoreReport
    List<MyReportVo> myScoreReport(Long userid);
}
