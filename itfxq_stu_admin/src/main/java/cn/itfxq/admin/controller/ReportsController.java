package cn.itfxq.admin.controller;


import cn.itfxq.admin.dto.MyReportVo;
import cn.itfxq.admin.service.IReportService;
import cn.itfxq.common.domain.Score;
import cn.itfxq.common.domain.SysUser;
import cn.itfxq.common.query.ScoreQuery;
import cn.itfxq.common.util.PageList;
import cn.itfxq.common.util.ResResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "报表接口")
public class ReportsController {

    @Autowired
    private IReportService reportService;

    //查询报表数据 getAvgReports
    @RequestMapping({"/score/getAvgReports"})
    @ResponseBody
    public ResResult getAvgReports(){
        try{
            HashMap map = new HashMap();
            map.put("courseAvgData",reportService.courseAvgReport());
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "查询成功",map);
        }catch(Exception e){
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                    "查询失败");
        }
    }


    @RequestMapping({"/score/getMyScoreReports"})
    @ResponseBody
    public List<MyReportVo> myScoreReport(@RequestBody Map map){
        Integer uid = (Integer)map.get("uid");
        return reportService.myScoreReport(Long.parseLong(uid+""));
    }



}
