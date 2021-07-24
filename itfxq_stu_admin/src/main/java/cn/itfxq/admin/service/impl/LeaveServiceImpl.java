package cn.itfxq.admin.service.impl;


import cn.itfxq.admin.mapper.LeaveMapper;
import cn.itfxq.admin.service.ILeaveService;
import cn.itfxq.common.domain.Leave;
import cn.itfxq.common.query.LeaveQuery;
import cn.itfxq.common.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: soulcoder-项目库分享圈
 * @datetime: 2020/7/1 8:34

 * @description: 成绩Service接口层
 */
@Service
public class LeaveServiceImpl implements ILeaveService {
    @Autowired
    private LeaveMapper leaveMapper;


    @Override
    public List<Leave> queryAll() {
        return leaveMapper.queryAll();
    }

    /**
     *  @description:   分页查询
     *  @params:  courseQuery
     *  @return  PageList
     */
    @Override
    public PageList listpage(LeaveQuery courseQuery) {
        PageList pageList  = new PageList();
        //查询总的条数
        Long total = leaveMapper.queryTotal(courseQuery);
        List<Leave> leaves = leaveMapper.queryData(courseQuery);
        pageList.setTotal(total);
        pageList.setRows(leaves);
        //分页查询的数据
        return pageList;
    }

    @Override
    public void addLeave(Leave leave) {
        leave.setStatus(0L);
        leave.setCreateTime(new Date());
        leaveMapper.addLeave(leave);
    }
    //批量删除成绩
    @Override
    public void batchRemove(List list) {
        leaveMapper.batchRemove(list);
    }

    @Override
    public void deleteLeave(Long id) {
        leaveMapper.deleteLeave(id);
    }

    @Override
    public void updateLeave(Leave leave) {
        leaveMapper.updateLeave(leave);
    }

    @Override
    public void auditLeave(Long id) {
        leaveMapper.auditLeave(id);
    }

    @Override
    public List<Leave> findMyLeaveRecord(Long userid) {
        return leaveMapper.findMyLeaveRecord(userid);
    }


}
