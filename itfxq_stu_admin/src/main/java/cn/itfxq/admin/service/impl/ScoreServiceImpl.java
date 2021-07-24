package cn.itfxq.admin.service.impl;


import cn.itfxq.admin.mapper.ScoreMapper;
import cn.itfxq.admin.service.IScoreService;
import cn.itfxq.common.domain.Score;
import cn.itfxq.common.query.ScoreQuery;
import cn.itfxq.common.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: soulcoder-项目库分享圈
 * @datetime: 2020/7/1 8:34

 * @description: 成绩Service接口层
 */
@Service
public class ScoreServiceImpl implements IScoreService {
    @Autowired
    private ScoreMapper scoreMapper;


    @Override
    public List<Score> queryAll() {
        return scoreMapper.queryAll();
    }




    /**
     *  @description:   分页查询
     *  @params:  courseQuery
     *  @return  PageList
     */
    @Override
    public PageList listpage(ScoreQuery courseQuery) {
        PageList pageList  = new PageList();
        //查询总的条数
        Long total = scoreMapper.queryTotal(courseQuery);
        List<Score> users = scoreMapper.queryData(courseQuery);
        pageList.setTotal(total);
        pageList.setRows(users);
        //分页查询的数据
        return pageList;
    }

    @Override
    public void addScore(Score score) {
        scoreMapper.addScore(score);
    }
    //批量删除成绩
    @Override
    public void batchRemove(List list) {
        scoreMapper.batchRemove(list);
    }

    @Override
    public void deleteScore(Long id) {
        scoreMapper.deleteScore(id);
    }

    @Override
    public void updateScore(Score score) {
        scoreMapper.updateScore(score);
    }


}
