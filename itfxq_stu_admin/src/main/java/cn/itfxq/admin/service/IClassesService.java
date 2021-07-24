package cn.itfxq.admin.service;



import cn.itfxq.common.domain.Classes;
import cn.itfxq.common.query.ClassesQuery;
import cn.itfxq.common.util.PageList;

import java.util.List;

/**
 * @author: soulcoder-项目库分享圈
 * @datetime: 2020/7/1 8:34

 * @description: 班级列表Service接口层
 */
public interface IClassesService {

    //查询所有用户
    List<Classes> queryAll();
    //添加用户
    Integer addClasses(Classes user);

    public PageList listpage(ClassesQuery userQuery);
    //删除数据 deleteClasses
    void deleteClasses(Long id);
    //批量删除
    void batchRemove(List ids);
    //修改保存用户
    void editSaveClasses(Classes user);
}
