package cn.itfxq.admin.controller;


import cn.itfxq.admin.service.ICourseService;
import cn.itfxq.admin.service.IReportService;
import cn.itfxq.admin.service.IScoreService;
import cn.itfxq.admin.service.ISysUserService;
import cn.itfxq.common.domain.Score;
import cn.itfxq.common.domain.SysUser;
import cn.itfxq.common.query.ScoreQuery;
import cn.itfxq.common.util.PageList;
import cn.itfxq.common.util.ResResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "成绩管理接口")
public class ScoreController {
    @Autowired
    private IScoreService scoreService;


    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ICourseService courseService;

    @Autowired
    private IReportService reportService;



    @GetMapping("/score/listpage")
    @ApiOperation("查询成绩分页数据接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ScoreQuery", value = "成绩查询对象", defaultValue = "scoreQuery对象")
    })
    @ResponseBody
    public ResResult listpage( ScoreQuery scoreQuery){
        PageList listpage = scoreService.listpage(scoreQuery);
        return new ResResult(ResResult.CodeStatus.OK, "获取成绩信息", listpage);
    }

    //添加成绩
    @PostMapping("/score/saveScore")
    @ApiOperation("添加成绩接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Score", value = "成绩对象")
    })
    @ResponseBody
    public ResResult saveScore(@RequestBody Score score){
        try {
            scoreService.addScore(score);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResResult<Map>(ResResult.CodeStatus.OK,
                "保存失败");
    }

    //修改成绩editSaveScore
    @PutMapping("/score/updateScore")
    @ApiOperation("修改成绩接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Score", value = "修改成绩对象")
    })
    @ResponseBody
    public ResResult updateScore(@RequestBody Score score){

        try {
            scoreService.updateScore(score);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "修改失败");
        }
    }



    //删除成绩
    @DeleteMapping("/score/deleteScore/{id}")
    @ResponseBody
    public ResResult deleteScore(@PathVariable("id") Long id){

        try {
            scoreService.deleteScore(id);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除失败");
        }
    }

    @PostMapping(value="/score/deleteBatchScore")
    @ApiOperation("批量成绩接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "如:88,89,99")
    })
    @ResponseBody
    public ResResult deleteBatchScore(String ids){
        String[] idsArr = ids.split(",");
        List list = new ArrayList();
        for(int i=0;i<idsArr.length;i++){
            list.add(idsArr[i]);
        }
        try{
            scoreService.batchRemove(list);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除成功");
        }catch(Exception e){
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除失败");
        }
    }

    /**
     * queryTeachers 查询所有老师
     *
     */
    @RequestMapping({"/score/queryStudents"})
    @ResponseBody
    public ResResult queryStudents(){
        try{

          List<SysUser> students = sysUserService.queryStudents();
            HashMap map = new HashMap();
            map.put("students",students);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "查询成功",map);
        }catch(Exception e){
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                    "查询失败");
        }
    }

    @RequestMapping({"/score/queryCourses"})
    @ResponseBody
    public ResResult queryCourses(){
        try{
            HashMap map = new HashMap();
            map.put("courses",courseService.queryAll());
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "查询成功",map);
        }catch(Exception e){
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                    "查询失败");
        }
    }

    @RequestMapping({"/score/queryScores"})
    @ResponseBody
    public ResResult queryScores(){
        try{
            HashMap map = new HashMap();
            map.put("scores",scoreService.queryAll());
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "查询成功",map);
        }catch(Exception e){
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                    "查询失败");
        }
    }

    //查询报表数据 getAvgReports
//
//    @RequestMapping({"/score/getAvgReports"})
//    @ResponseBody
//    public ResResult getAvgReports(){
//        try{
//            HashMap map = new HashMap();
//            map.put("courseAvgData",reportService.courseAvgReport());
//            return  new ResResult<Map>(ResResult.CodeStatus.OK,
//                    "查询成功",map);
//        }catch(Exception e){
//            e.printStackTrace();
//            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
//                    "查询失败");
//        }
//    }



}
