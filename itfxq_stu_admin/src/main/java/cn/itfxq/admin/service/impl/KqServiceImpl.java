package cn.itfxq.admin.service.impl;


import cn.itfxq.admin.mapper.KqMapper;
import cn.itfxq.admin.service.IKqService;
import cn.itfxq.common.domain.Kq;
import cn.itfxq.common.query.KqQuery;
import cn.itfxq.common.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: TODO
 * @author: xxx

 * @datetime: 2020/7/1 15:00
 */
@Service
public class KqServiceImpl implements IKqService {

    @Autowired
    private KqMapper kqMapper;

    @Override
    public List<Kq> queryAll() {
        return kqMapper.queryAll();
    }

    @Override
    public PageList listpage(KqQuery kqQuery) {
        PageList pageList  = new PageList();
        //查询总的条数
        Long total = kqMapper.queryTotal(kqQuery);
        List<Kq> users = kqMapper.queryData(kqQuery);
        pageList.setTotal(total);
        pageList.setRows(users);
        //分页查询的数据
        return pageList;
    }

    //上课考勤
    @Override
    public void upKq(Long loginUserId) {
        Kq kq = new Kq();
        kq.setUserid(loginUserId);
        kq.setUpClassTime(new Date());
        kq.setCurrentTime(new Date());
        kqMapper.upKq(kq);
    }
    //下课考勤
    @Override
    public void downKq(Long loginUserId) {

        Kq kq = new Kq();
        kq.setUserid(loginUserId);
        kq.setDownClassTime(new Date());
        kq.setCurrentTime(new Date());
        kqMapper.downKq(kq);
    }

    @Override
    //App上课打卡
    public Long appUpKq(long userid) {
        Kq kq = new Kq();
        kq.setUserid(userid);
        kq.setUpClassTime(new Date());
        kq.setCurrentTime(new Date());
        kqMapper.upKq(kq);
        return kq.getId();
    }

    //查询打开记录
    @Override
    public Kq queryRecoredByKqId(Long kqId) {
        return kqMapper.queryRecoredByKqId(kqId);
    }

    //判断是否已经打过卡
    @Override
    public Kq queryUserRecordsByUserIdAndCurrentTime(Map mp) {
        return kqMapper.queryUserRecordsByUserIdAndCurrentTime(mp);
    }

    //app下班打卡
    @Override
    public void appDownKq(long userid) {
        Kq kq = new Kq();
        kq.setUserid(userid);
        kq.setDownClassTime(new Date());
        kq.setCurrentTime(new Date());
        kqMapper.downKq(kq);

    }
}
