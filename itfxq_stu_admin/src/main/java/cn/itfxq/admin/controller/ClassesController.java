package cn.itfxq.admin.controller;


import cn.itfxq.admin.service.IClassesService;
import cn.itfxq.common.domain.Classes;
import cn.itfxq.common.query.ClassesQuery;
import cn.itfxq.common.util.PageList;
import cn.itfxq.common.util.ResResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "班级管理接口")
public class ClassesController {
    @Autowired
    private IClassesService classesService;


    @GetMapping("/classes/listpage")
    @ApiOperation("查询班级分页数据接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ClassesQuery", value = "班级查询对象", defaultValue = "classesQuery对象")
    })
    @ResponseBody
    public ResResult listpage( ClassesQuery classesQuery){
        PageList listpage = classesService.listpage(classesQuery);
        return new ResResult(ResResult.CodeStatus.OK, "获取学生信息", listpage);
    }

    //添加班级
    @PostMapping("/classes/saveClasses")
    @ApiOperation("添加班级接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Classes", value = "班级对象")
    })
    @ResponseBody
    public ResResult saveClasses(@RequestBody Classes classes){
        try {
            classesService.addClasses(classes);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResResult<Map>(ResResult.CodeStatus.OK,
                "保存失败");
    }

    //修改班级editSaveClasses
    @PutMapping("/classes/updateClasses")
    @ApiOperation("修改班级接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Classes", value = "修改班级对象")
    })
    @ResponseBody
    public ResResult updateClasses(@RequestBody Classes classes){
        System.out.println("修改班级...."+classes);
        try {
            classesService.editSaveClasses(classes);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResResult<Map>(ResResult.CodeStatus.OK,
                "修改失败");
    }

    //删除班级
    @DeleteMapping("/classes/deleteClasses/{id}")
    @ApiOperation("删除班级接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "如:88",required = true)
    })
    @ResponseBody
    public ResResult deleteClasses(@PathVariable("id") Long id){

        try {
            classesService.deleteClasses(id);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除失败");
        }
    }

    @PostMapping(value="/classes/deleteBatchClasses")
    @ApiOperation("批量班级接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "如:88,89,99")
    })
    @ResponseBody
    public ResResult deleteBatchClasses(String ids){
        String[] idsArr = ids.split(",");
        List list = new ArrayList();
        for(int i=0;i<idsArr.length;i++){
            list.add(idsArr[i]);
        }
        try{
            classesService.batchRemove(list);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除成功");
        }catch(Exception e){
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除失败");
        }
    }



}
