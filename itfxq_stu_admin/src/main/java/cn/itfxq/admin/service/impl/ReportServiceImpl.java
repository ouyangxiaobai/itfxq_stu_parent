package cn.itfxq.admin.service.impl;


import cn.itfxq.admin.dto.MyReportVo;
import cn.itfxq.admin.dto.ReportVo;
import cn.itfxq.admin.mapper.ReportMapper;
import cn.itfxq.admin.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: TODO
 * @author: xxx

 * @datetime: 2020/7/1 18:32
 */
@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private ReportMapper reportMapper;

    //课程平均分报表
    @Override
    public List<ReportVo> courseAvgReport() {
        return reportMapper.courseAvgReport();
    }

    //每个课程成绩 myScoreReport
    @Override
    public  List<MyReportVo> myScoreReport(Long userid){
        return reportMapper.myScoreReport(userid);
    }
}
