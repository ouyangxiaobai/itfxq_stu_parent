package cn.itfxq.admin.service;

import cn.itfxq.common.domain.Score;
import cn.itfxq.common.query.ScoreQuery;
import cn.itfxq.common.util.PageList;

import java.util.List;

/**
 * @description: TODO
 * @author: xxx

 * @datetime: 2020/7/1 17:10
 */
public interface IScoreService  {
    //查询成绩
    List<Score> queryAll();
    //分页查询成绩记录
    PageList listpage(ScoreQuery scoreQuery);
    //添加成绩
    void addScore(Score score);
    //批量删除成绩
    void batchRemove(List list);
    //删除成绩
    void deleteScore(Long id);
    //修改成绩
    void updateScore(Score score);
}
