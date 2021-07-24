package cn.itfxq.admin.service;



import cn.itfxq.common.domain.Kq;
import cn.itfxq.common.query.KqQuery;
import cn.itfxq.common.util.PageList;

import java.util.List;
import java.util.Map;

/**
 * @author: soulcoder-项目库分享圈
 * @datetime: 2020/7/1 8:34

 * @description: 考勤记录Service接口层
 */
public interface IKqService {

    //查询考勤记录
    List<Kq> queryAll();
    //分页查询考勤记录
    PageList listpage(KqQuery kqQuery);
    //上课考勤
    void upKq(Long loginUserId);
    //下课考勤
    void downKq(Long loginUserId);
    //app上班考勤
    Long appUpKq(long parseLong);
    //app上班考勤记录
    Kq queryRecoredByKqId(Long kqId);
    //判断当前用户今日是否已经打过卡了
    Kq queryUserRecordsByUserIdAndCurrentTime(Map mp);
    //app下班考勤打卡
    void appDownKq(long parseLong);
}
