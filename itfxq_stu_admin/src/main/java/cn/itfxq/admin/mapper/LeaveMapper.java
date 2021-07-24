package cn.itfxq.admin.mapper;



import cn.itfxq.common.domain.Leave;
import cn.itfxq.common.domain.Leave;
import org.apache.ibatis.annotations.*;

import java.util.List;



@Mapper
public interface LeaveMapper extends BaseMapper<Leave> {

    //添加
    @Insert("insert into t_leave(userid,username,leavetime,day,content,createTime,status) " +
            "values(#{userid},#{username},#{leavetime},#{day},#{content},#{createTime},#{status})")
    void addLeave(Leave leave);

    //删除数据 deleteLeave
    @Delete("delete from t_leave where id =#{id}")
    void deleteLeave(Long id);
    //批量删除
    void batchRemove(List ids);
    //修改Leave
    void updateLeave(Leave leave);

    @Update("update t_leave  set status = 1 where id=#{id}")
    void auditLeave(Long id);

    //查询我的请假
    @Select("select * from t_leave where userid = #{userid}")
    List<Leave> findMyLeaveRecord(Long userid);
}
