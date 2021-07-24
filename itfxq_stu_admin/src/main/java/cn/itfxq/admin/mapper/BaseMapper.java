package cn.itfxq.admin.mapper;


import cn.itfxq.common.query.BaseQuery;

import java.util.List;

/**
 * @description: TODO
 * @author: xxx

 * @datetime: 2020/7/1 14:46
 */
public interface BaseMapper<T> {
    //查询总的条数
    Long queryTotal(BaseQuery baseQuery);
    //分页查询数据
    List<T> queryData(BaseQuery baseQuery);
    //查询所有记录
    List<T> queryAll();
}
