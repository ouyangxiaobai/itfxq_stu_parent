package cn.itfxq.admin.mapper;



import cn.itfxq.common.domain.Course;
import cn.itfxq.common.query.CourseQuery;

import java.util.List;

/**
 * @author: soulcoder-项目库分享圈
 * @datetime: 2020/7/1 8:34

 * @description: 课程列表Mapper层
 */
public interface CourseMapper {

    //查询所有课程
    List<Course> queryAll();
    //添加课程
    Integer addCourse(Course course);
    //查询总的条数
    Long queryTotal(CourseQuery courseQuery);
    //分页查询数据
    List<Course> queryData(CourseQuery courseQuery);
    //删除数据 deleteCourse
    void deleteCourse(Long id);
    //批量删除
    void batchRemove(List ids);
    //修改保存用户
    void editSaveCourse(Course course);
}
