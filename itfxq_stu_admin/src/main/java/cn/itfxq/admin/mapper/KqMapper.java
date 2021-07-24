package cn.itfxq.admin.mapper;


import cn.itfxq.common.domain.Kq;

import java.util.Map;

/**
 * @description: 考勤Mapper类
 * @author: xxx

 * @datetime: 2020/7/1 14:43
 */
public interface KqMapper extends BaseMapper<Kq> {
    //上课考勤
    void upKq(Kq kq);
    //下课考勤
    void downKq(Kq kq);
    //app上班考勤记录
    Kq queryRecoredByKqId(Long kqId);
    //判断是否已经打过卡了
    Kq queryUserRecordsByUserIdAndCurrentTime(Map mp);
}
