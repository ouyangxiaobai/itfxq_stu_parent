package cn.itfxq.admin.mapper;

import cn.itfxq.common.domain.Classes;
import cn.itfxq.common.domain.News;
import cn.itfxq.common.query.ClassesQuery;
import cn.itfxq.common.query.NewsQuery;

import java.util.List;

/**
 * @author: soulcoder
 * @datetime: 2020/7/1 8:34
 * @description: 班级Mapper
 */
public interface NewsMapper {

    //查询所有的新闻
    List<News> queryAll();
    //查询总的条数
    Long queryTotal(NewsQuery newsQuery);
    //分页查询数据
    List<News> queryData(NewsQuery newsQuery);
    //保存新闻
    void saveNews(News news);
    //修改新闻
    void updateNews(News news);
    //删除新闻
    void deleteNewsById(Long id);
    //查询新闻明细
    News getNewsDetail(Long id);
}
