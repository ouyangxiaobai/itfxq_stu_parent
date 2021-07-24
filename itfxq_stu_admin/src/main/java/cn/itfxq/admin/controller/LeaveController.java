package cn.itfxq.admin.controller;


import cn.itfxq.admin.service.ICourseService;
import cn.itfxq.admin.service.IReportService;
import cn.itfxq.admin.service.ILeaveService;
import cn.itfxq.admin.service.ISysUserService;
import cn.itfxq.common.domain.Leave;
import cn.itfxq.common.domain.SysUser;
import cn.itfxq.common.query.LeaveQuery;
import cn.itfxq.common.util.PageList;
import cn.itfxq.common.util.ResResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请假接口
 */
@Controller
public class LeaveController {
    @Autowired
    private ILeaveService leaveService;


    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ICourseService courseService;

    @Autowired
    private IReportService reportService;



    @GetMapping("/leave/listpage")
    @ResponseBody
    public ResResult listpage( LeaveQuery leaveQuery){
        PageList listpage = leaveService.listpage(leaveQuery);
        return new ResResult(ResResult.CodeStatus.OK, "获取请假信息", listpage);
    }

    //添加请假
    @PostMapping("/leave/saveLeave")
    @ResponseBody
    public ResResult saveLeave(@RequestBody Leave leave){
        try {
            leaveService.addLeave(leave);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResResult<Map>(ResResult.CodeStatus.OK,
                "保存失败");
    }

    //修改请假editSaveLeave
    @PutMapping("/leave/updateLeave")
    @ResponseBody
    public ResResult updateLeave(@RequestBody Leave leave){

        try {
            leaveService.updateLeave(leave);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "修改失败");
        }
    }



    //删除请假
    @DeleteMapping("/leave/deleteLeave/{id}")
    @ResponseBody
    public ResResult deleteLeave(@PathVariable("id") Long id){

        try {
            leaveService.deleteLeave(id);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除失败");
        }
    }

    //审核请假
    @PostMapping("/leave/auditLeave/{id}")
    @ResponseBody
    public ResResult auditLeave(@PathVariable("id") Long id){

        try {
            leaveService.auditLeave(id);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "审核成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "审核失败");
        }
    }

    @PostMapping(value="/leave/deleteBatchLeave")
    @ResponseBody
    public ResResult deleteBatchLeave(String ids){
        String[] idsArr = ids.split(",");
        List list = new ArrayList();
        for(int i=0;i<idsArr.length;i++){
            list.add(idsArr[i]);
        }
        try{
            leaveService.batchRemove(list);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除成功");
        }catch(Exception e){
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除失败");
        }
    }



    @RequestMapping({"/leave/queryMyLeave"})
    @ResponseBody
    public ResResult queryMyLeave(@RequestBody Leave leave){
        try{
            HashMap map = new HashMap();
            map.put("leaves",leaveService.findMyLeaveRecord(leave.getUserid()));
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "查询成功",map);
        }catch(Exception e){
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                    "查询失败");
        }
    }







}
