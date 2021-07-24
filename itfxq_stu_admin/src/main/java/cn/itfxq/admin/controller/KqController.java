package cn.itfxq.admin.controller;


import cn.itfxq.admin.service.IKqService;
import cn.itfxq.auth.config.util.LgUtils;
import cn.itfxq.common.domain.Kq;
import cn.itfxq.common.query.KqQuery;
import cn.itfxq.common.util.PageList;
import cn.itfxq.common.util.ResResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@Api(tags = "考勤管理接口")
public class KqController {
    @Autowired
    private IKqService kqService;


    @GetMapping("/kq/listpage")
    @ApiOperation("查询考勤分页数据接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "KqQuery", value = "考勤查询对象", defaultValue = "kqQuery对象")
    })
    @ResponseBody
    public ResResult listpage( KqQuery kqQuery){
        PageList listpage = kqService.listpage(kqQuery);
        return new ResResult(ResResult.CodeStatus.OK, "获取考勤信息", listpage);
    }

    @GetMapping("/kq/upKq")
    @ApiOperation("上课打卡")
    @ResponseBody
    public ResResult upKq(HttpServletRequest req){
        try {
            Long loginUserId = LgUtils.getLoginUserId(req);

           kqService.upKq(loginUserId);
            return new ResResult(ResResult.CodeStatus.OK, "打卡成功");
        }catch(Exception e){
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                    "打卡失败");
        }
    }

    @GetMapping("/kq/downKq")
    @ApiOperation("放学打卡")
    @ResponseBody
    public ResResult downKq(HttpServletRequest req){
        try {
            Long loginUserId = LgUtils.getLoginUserId(req);
            kqService.downKq(loginUserId);
            return new ResResult(ResResult.CodeStatus.OK, "打卡成功");
        }catch(Exception e){
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                    "打卡失败");
        }
    }


    //app端使用
    @RequestMapping("/kq/appUpKq")
    @ApiOperation("上课打卡")
    @ResponseBody
    public ResResult appUpKq(@RequestBody Map mp){
        try {
            Integer uid = (Integer)mp.get("uid");
            //考勤记录
            Long kqId = kqService.appUpKq(Long.parseLong(uid + ""));
            //考勤记录
            Kq kq = kqService.queryRecoredByKqId(kqId);
            return new ResResult(ResResult.CodeStatus.OK, "打卡成功",kq);
        }catch(Exception e){
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                    "打卡失败");
        }
    }

    //app端使用
    @RequestMapping("/kq/appDownKq")
    @ApiOperation("放学打卡")
    @ResponseBody
    public ResResult appDownKq(@RequestBody Map mp){
        try {
             Integer uid = (Integer)mp.get("uid");
             //放学打卡
             kqService.appDownKq(Long.parseLong(uid + ""));
             mp.put("currentTime",new Date());
             mp.put("userid",uid+"");
             //考勤记录
             Kq kq = kqService.queryUserRecordsByUserIdAndCurrentTime(mp);

            return new ResResult(ResResult.CodeStatus.OK, "操作成功",kq);
        }catch(Exception e){
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                    "操作失败");
        }
    }

    //app端使用
    @RequestMapping("/kq/appIsUpDk")
    @ApiOperation("判断是否已经打过卡")
    @ResponseBody
    public ResResult appIsUpDk(@RequestBody Map mp){
        try {
            mp.put("currentTime",new Date());
            Kq kq = kqService.queryUserRecordsByUserIdAndCurrentTime(mp);
            return new ResResult(ResResult.CodeStatus.OK, "操作成功",kq);
        }catch(Exception e){
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                    "操作失败");
        }
    }







}
