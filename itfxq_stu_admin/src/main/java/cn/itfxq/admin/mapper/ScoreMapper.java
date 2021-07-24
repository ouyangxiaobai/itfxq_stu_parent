package cn.itfxq.admin.mapper;



import cn.itfxq.common.domain.Score;

import java.util.List;


/**
 * @description: ScoreMapper 分数类
 * @author: xxx

 * @datetime: 2020/7/1 14:43
 */
public interface ScoreMapper extends BaseMapper<Score> {

    //添加成绩
    void addScore(Score score);
    //删除数据 deleteScore
    void deleteScore(Long id);
    //批量删除
    void batchRemove(List ids);
    //修改Score
    void updateScore(Score score);
}
