package cn.itfxq.admin.controller;

import cn.itfxq.admin.service.IClassesService;
import cn.itfxq.common.domain.Classes;
import cn.itfxq.common.domain.SysUser;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description: 公共的controller
 * @author: xxx

 * @datetime: 2020/7/3 19:37
 */
@RestController
public class CommonController {

    @Autowired
    private IClassesService classesService;


    /**
     *  queryClasses 查询课程
     */
    @RequestMapping({"/common/queryClasses"})
    public List<Classes> queryClasses(){
        //查询班级数据
        List<Classes> classes = classesService.queryAll();
        return classes;
    }


}
