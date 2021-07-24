package cn.itfxq.admin.mapper;

import cn.itfxq.common.domain.Classes;
import cn.itfxq.common.query.ClassesQuery;

import java.util.List;

/**
 * @author: soulcoder
 * @datetime: 2020/7/1 8:34
 * @description: 班级Mapper
 */
public interface ClassesMapper {

    //查询所有用户
    List<Classes> queryAll();
    //添加用户
    Integer addClasses(Classes user);
    //查询总的条数
    Long queryTotal(ClassesQuery userQuery);
    //分页查询数据
    List<Classes> queryData(ClassesQuery userQuery);
    //删除数据 deleteClasses
    void deleteClasses(Long id);
    //批量删除
    void batchRemove(List ids);
    //修改保存用户
    void editSaveClasses(Classes user);
}
