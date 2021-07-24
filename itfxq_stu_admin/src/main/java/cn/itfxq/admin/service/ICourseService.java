package cn.itfxq.admin.service;




import cn.itfxq.common.domain.Course;
import cn.itfxq.common.query.CourseQuery;
import cn.itfxq.common.util.PageList;

import java.util.List;

/**
 * @author: soulcoder-项目库分享圈
 * @datetime: 2020/7/1 8:34

 * @description: 课程列表Service接口层
 */
public interface ICourseService {

    //查询所有用户
    List<Course> queryAll();
    //添加用户
    Integer addCourse(Course user);

    public PageList listpage(CourseQuery courseQuery);
    //删除数据 deleteCourse
    void deleteCourse(Long id);
    //批量删除
    void batchRemove(List ids);
    //修改保存用户
    void editSaveCourse(Course course);
}
