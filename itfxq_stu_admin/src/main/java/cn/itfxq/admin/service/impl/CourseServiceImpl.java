package cn.itfxq.admin.service.impl;


import cn.itfxq.admin.mapper.CourseMapper;
import cn.itfxq.admin.service.ICourseService;
import cn.itfxq.common.domain.Course;
import cn.itfxq.common.query.CourseQuery;
import cn.itfxq.common.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: soulcoder-项目库分享圈
 * @datetime: 2020/7/1 8:34

 * @description: 课程列表Service接口层
 */
@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<Course> queryAll() {
        return courseMapper.queryAll();
    }

    @Override
    public Integer addCourse(Course course) {
        //设置创建时间
        course.setCreateTime(new Date());
        return courseMapper.addCourse(course);
    }


    /**
     *  @description:   分页查询
     *  @params:  courseQuery
     *  @return  PageList
     */
    @Override
    public PageList listpage(CourseQuery courseQuery) {
        PageList pageList  = new PageList();
        //查询总的条数
        Long total = courseMapper.queryTotal(courseQuery);
        List<Course> users = courseMapper.queryData(courseQuery);
        pageList.setTotal(total);
        pageList.setRows(users);
        //分页查询的数据
        return pageList;
    }

    //删除用户
    @Override
    public void deleteCourse(Long id) {
        courseMapper.deleteCourse(id);
    }

    @Override
    public void batchRemove(List list) {
        courseMapper.batchRemove(list);
    }

    @Override
    public void editSaveCourse(Course course) {
        courseMapper.editSaveCourse(course);
    }
}
