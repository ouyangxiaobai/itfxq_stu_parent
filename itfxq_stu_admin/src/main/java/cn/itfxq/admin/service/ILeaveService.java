package cn.itfxq.admin.service;

import cn.itfxq.common.domain.Leave;
import cn.itfxq.common.query.LeaveQuery;
import cn.itfxq.common.util.PageList;

import java.util.List;

/**
 * @description: ILeaveService
 * @author: xxx

 * @datetime: 2020/7/1 17:10
 */
public interface ILeaveService {
    //查询请假
    List<Leave> queryAll();
    //分页查询请假记录
    PageList listpage(LeaveQuery leaveQuery);
    //添加请假
    void addLeave(Leave leave);
    //批量删除请假
    void batchRemove(List list);
    //删除请假
    void deleteLeave(Long id);
    //修改请假
    void updateLeave(Leave leave);

    void auditLeave(Long id);

    List<Leave> findMyLeaveRecord(Long userid);
}
