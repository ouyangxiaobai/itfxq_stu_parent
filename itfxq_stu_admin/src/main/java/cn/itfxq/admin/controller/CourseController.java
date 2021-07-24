package cn.itfxq.admin.controller;


import cn.itfxq.admin.service.ICourseService;
import cn.itfxq.admin.service.ISysUserService;
import cn.itfxq.common.domain.Course;
import cn.itfxq.common.domain.SysUser;
import cn.itfxq.common.query.CourseQuery;
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

@Controller
@Api(tags = "课程管理接口")
public class CourseController {
    @Autowired
    private ICourseService courseService;


    @Autowired
    private ISysUserService sysUserService;



    @GetMapping("/course/listpage")
    @ApiOperation("查询课程分页数据接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "CourseQuery", value = "课程查询对象", defaultValue = "courseQuery对象")
    })
    @ResponseBody
    public ResResult listpage( CourseQuery courseQuery){
        PageList listpage = courseService.listpage(courseQuery);
        return new ResResult(ResResult.CodeStatus.OK, "获取学生信息", listpage);
    }

    //添加课程
    @PostMapping("/course/saveCourse")
    @ApiOperation("添加课程接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Course", value = "课程对象")
    })
    @ResponseBody
    public ResResult saveCourse(@RequestBody Course course){
        try {
            courseService.addCourse(course);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResResult<Map>(ResResult.CodeStatus.OK,
                "保存失败");
    }

    //修改课程editSaveCourse
    @PutMapping("/course/updateCourse")
    @ApiOperation("修改课程接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Course", value = "修改课程对象")
    })
    @ResponseBody
    public ResResult updateCourse(@RequestBody Course course){
        System.out.println("修改课程...."+course);
        try {
            courseService.editSaveCourse(course);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResResult<Map>(ResResult.CodeStatus.OK,
                "修改失败");
    }

    //删除课程
    @DeleteMapping("/course/deleteCourse/{id}")
    @ApiOperation("删除课程接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "如:88",required = true)
    })
    @ResponseBody
    public ResResult deleteCourse(@PathVariable("id") Long id){

        try {
            courseService.deleteCourse(id);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除失败");
        }
    }

    @PostMapping(value="/course/deleteBatchCourse")
    @ApiOperation("批量课程接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "如:88,89,99")
    })
    @ResponseBody
    public ResResult deleteBatchCourse(String ids){
        String[] idsArr = ids.split(",");
        List list = new ArrayList();
        for(int i=0;i<idsArr.length;i++){
            list.add(idsArr[i]);
        }
        try{
            courseService.batchRemove(list);
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
    @RequestMapping({"/course/queryTeachers"})
    @ResponseBody
    public ResResult queryTeachers(){
        try{

          List<SysUser> teachers = sysUserService.queryTeachers();
            HashMap map = new HashMap();
            map.put("teachers",teachers);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "查询成功",map);
        }catch(Exception e){
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                    "查询失败");
        }
    }



}
