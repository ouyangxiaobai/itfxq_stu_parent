package cn.itfxq.common.query;

import lombok.Data;

@Data
public class UserQuery extends BaseQuery {

    //登录用户id
    private Integer id;


    private String username;

    private String email;

    private Long type;



}
