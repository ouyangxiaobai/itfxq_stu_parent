package cn.itfxq.admin.mapper;





import cn.itfxq.common.domain.SysMenu;
import cn.itfxq.common.domain.SysUser;
import cn.itfxq.common.query.UserQuery;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //根据用户id查询菜单
    List<SysMenu> findByUserId(Long userId);
    //查询总数
    Long findTotal(UserQuery userQuery);
    //分页查询数据
    List<SysUser> findData(UserQuery userQuery);
    //保存用户
    void saveUser(SysUser umsAdmin);
    //删除数据deleteUserById
    void deleteUserById(Long id);
    //修改用户
    void updateUser(SysUser umsAdmin);
    //保存用户角色
    void saveUserRole(List<Map> list);
    //deleteUserRoleByUserId
    void deleteUserRoleByUserId(Long userId);
    //根据用户名查询用户
    SysUser selectByUsername(String username);
    //查询所有的用户
    List<SysUser> queryAll();
    //查询所有的老师
    List<SysUser> queryTeachers();
    //查询所有的学生
    List<SysUser> queryStudents();
}
