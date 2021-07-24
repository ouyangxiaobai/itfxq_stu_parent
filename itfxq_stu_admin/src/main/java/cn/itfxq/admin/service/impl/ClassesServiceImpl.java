package cn.itfxq.admin.service.impl;


import cn.itfxq.admin.mapper.ClassesMapper;
import cn.itfxq.admin.service.IClassesService;
import cn.itfxq.common.domain.Classes;
import cn.itfxq.common.query.ClassesQuery;
import cn.itfxq.common.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClassesServiceImpl implements IClassesService {
    @Autowired
    private ClassesMapper classesMapper;


    @Override
    public List<Classes> queryAll() {
        return classesMapper.queryAll();
    }

    @Override
    public Integer addClasses(Classes classes) {
        //设置创建时间
        classes.setCreateTime(new Date());

        return classesMapper.addClasses(classes);
    }



    @Override
    public PageList listpage(ClassesQuery userQuery) {
        PageList pageList  = new PageList();
        //查询总的条数
        Long total = classesMapper.queryTotal(userQuery);
        List<Classes> users = classesMapper.queryData(userQuery);
        pageList.setTotal(total);
        pageList.setRows(users);
        //分页查询的数据
        return pageList;
    }

    //删除用户
    @Override
    public void deleteClasses(Long id) {
        classesMapper.deleteClasses(id);
    }

    @Override
    public void batchRemove(List list) {
        classesMapper.batchRemove(list);
    }

    @Override
    public void editSaveClasses(Classes classes) {
        classesMapper.editSaveClasses(classes);
    }
}
