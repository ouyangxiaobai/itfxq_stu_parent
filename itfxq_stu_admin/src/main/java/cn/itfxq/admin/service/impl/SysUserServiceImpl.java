package cn.itfxq.admin.service.impl;

import cn.itfxq.admin.mapper.UserMapper;
import cn.itfxq.admin.service.ISysUserService;
import cn.itfxq.common.domain.SysMenu;
import cn.itfxq.common.domain.SysUser;
import cn.itfxq.common.query.UserQuery;
import cn.itfxq.common.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户管理服务
 * <p>
 * Description:
 * </p>
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private UserMapper sysUserMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public SysUser get(String username) {
        return sysUserMapper.selectByUsername(username);
    }

    @Override
    public List<SysMenu> findByUserId(Long userId) {
        return sysUserMapper.findByUserId(userId);
    }

    @Override
    @Transactional
    public PageList findPage(UserQuery userQuery) {
        Long total =  sysUserMapper.findTotal(userQuery);
        List<SysUser> rows = sysUserMapper.findData(userQuery);
        PageList pageList = new PageList();
        pageList.setTotal(total);
        pageList.setRows(rows);
        return pageList;
    }

    //保存用户
    @Override
    @Transactional
    public void saveUser(SysUser SysUser) {
        SysUser.setPassword(passwordEncoder.encode(SysUser.getPassword()));
        SysUser.setStatus(1);
        SysUser.setCreateTime(new Date());
        sysUserMapper.saveUser(SysUser);
    }

    @Override
    public void deleteUserById(Long id) {
        sysUserMapper.deleteUserById(id);
    }

    @Override
    public void updateUser(SysUser SysUser) {
        SysUser.setPassword(passwordEncoder.encode(SysUser.getPassword()));
        sysUserMapper.updateUser(SysUser);
    }

    /**
     *  @description: 保存用户角色
     *  @params: {roleId:1,userId:1}
     *  @return
     */
    @Override
    public void saveUserRole(List<Map> list) {
        Long userId = 0L;
        for (Map map : list) {
            Integer userIdStr = (Integer)map.get("userId");
            userId = Long.valueOf(userIdStr);
        }
        //先删除用户的角色
        sysUserMapper.deleteUserRoleByUserId(userId);
        //在保存
        sysUserMapper.saveUserRole(list);
    }

    //注册用户
    @Override
    public void regUser(SysUser sysUser) {
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        sysUser.setStatus(1);
        sysUser.setCreateTime(new Date());

        sysUserMapper.saveUser(sysUser);
    }

    @Override
    public List<SysUser> queryAll() {
        return sysUserMapper.queryAll();
    }

    @Override
    public List<SysUser> queryTeachers() {
        return sysUserMapper.queryTeachers();
    }

    @Override
    public List<SysUser> queryStudents() {
        return sysUserMapper.queryStudents();
    }

    /**
     * 初始化用户对象
     * @param sysUser
     */
    private void initSysUser(SysUser sysUser) {
        // 初始化创建时间
        sysUser.setCreateTime(new Date());
        sysUser.setLoginTime(new Date());

        // 初始化状态
        if (sysUser.getStatus() == null) {
            sysUser.setStatus(0);
        }
        // 密码加密
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
    }



}
