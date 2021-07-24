package cn.itfxq.common.query;

import lombok.Data;


@Data
public class BaseQuery {
    //开始位置
    public Integer currentPage = 1;
    //每页显示条数
    public Integer pageSize = 10;

    public Integer getStart(){
        return  (this.currentPage-1)*this.pageSize;
    }
}
