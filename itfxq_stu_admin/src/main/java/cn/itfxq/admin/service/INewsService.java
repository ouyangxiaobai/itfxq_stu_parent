package cn.itfxq.admin.service;



import cn.itfxq.common.domain.Classes;
import cn.itfxq.common.domain.News;
import cn.itfxq.common.query.ClassesQuery;
import cn.itfxq.common.query.NewsQuery;
import cn.itfxq.common.util.PageList;

import java.util.List;

/**
 * @author: soulcoder-项目库分享圈
 * @datetime: 2020/7/1 8:34

 * @description: 新闻列表Service接口层
 */
public interface INewsService {

    //查询所有新闻用户
    List<News> queryAll();
    //分页查询
     PageList listpage(NewsQuery newsQuery);
    //保存新闻
    void saveNews(News news);
    //更新修改
    void updateNews(News news);
    //删除新闻
    void deleteNewsById(Long id);
    //查询新闻明细
    News getNewsDetail(Long id);
}
