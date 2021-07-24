package cn.itfxq.common.util;

import lombok.Data;

@Data
public class AjaxResponseBody {
    private String status="200";
    private String msg="操作成功";
    private Object resultObj;

    public AjaxResponseBody(String msg) {
        this.status = "500";
        this.msg = msg;
    }

    public AjaxResponseBody() {
    }
}
