package cn.itfxq.admin.controller;



import cn.itfxq.admin.service.ISysUserService;
import cn.itfxq.common.domain.SysUser;
import cn.itfxq.common.query.UserQuery;
import cn.itfxq.common.util.PageList;
import cn.itfxq.common.util.ResResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@Api(tags = "教师管理接口")
public class TeacherController {

    @Autowired
    private ISysUserService userService;


    @RequestMapping("/teacher/listpage")
    @ResponseBody
    public ResResult listpage( UserQuery userQuery){
        System.out.println("传递参数:"+userQuery);
        userQuery.setType(2L);//2表示老师
        PageList pageList = userService.findPage(userQuery);
       return new ResResult(ResResult.CodeStatus.OK, "获取老师信息", pageList);
    }


    //修改用户editSaveUser
    @PutMapping("/teacher/updateTeacher")
    @ApiOperation("修改用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "User", value = "修改用户对象")
    })
    @ResponseBody
    public ResResult updateTeacher(@RequestBody  SysUser user){
        try {
            userService.updateUser(user);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "保存成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                "保存失败");
    }

    @DeleteMapping(value = "/teacher/deleteTeacher/{id}")
    @ResponseBody
    public ResResult deleteTeacher(@PathVariable("id") Long id) throws Exception {
        try {
            userService.deleteUserById(id);
            return  new ResResult<Map>(ResResult.CodeStatus.OK,
                    "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResResult<Map>(ResResult.CodeStatus.FAIL,
                    "删除失败");
        }
    }


}
