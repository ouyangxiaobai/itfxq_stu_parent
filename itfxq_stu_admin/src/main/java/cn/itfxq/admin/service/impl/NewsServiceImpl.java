package cn.itfxq.admin.service.impl;

import cn.itfxq.admin.mapper.NewsMapper;
import cn.itfxq.admin.service.INewsService;
import cn.itfxq.common.domain.News;
import cn.itfxq.common.query.NewsQuery;
import cn.itfxq.common.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> queryAll() {
        return newsMapper.queryAll();
    }


    @Override
    public PageList listpage(NewsQuery newsQuery) {
        PageList pageList  = new PageList();
        //查询总的条数
        Long total = newsMapper.queryTotal(newsQuery);
        List<News> news = newsMapper.queryData(newsQuery);
        pageList.setTotal(total);
        pageList.setRows(news);
        //分页查询的数据
        return pageList;
    }

    @Override
    public void saveNews(News news) {
        news.setCreateTime(new Date());
        newsMapper.saveNews(news);
    }

    @Override
    public void updateNews(News news) {
        newsMapper.updateNews(news);
    }

    @Override
    public void deleteNewsById(Long id) {
        newsMapper.deleteNewsById(id);
    }

    @Override
    public News getNewsDetail(Long id) {
        return newsMapper.getNewsDetail(id);
    }


}
