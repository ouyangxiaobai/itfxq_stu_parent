package cn.itfxq.common.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: soulcoder
 * @datetime:  20200615 23:11
 * @description: TODO
 */
@Data
public class SysMenu {

    private Long id;

    protected Long createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    protected Date createDate;

    protected Long updateBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    protected Date updateDate;
    protected String remarks;

    protected Integer delFlag;
    protected transient Map<String, String> sqlMap =  new HashMap<>();

    public static final Integer DEL_FLAG_NORMAL = 0;
    public static final Integer DEL_FLAG_DELETE = 1;

    protected Boolean hasAdmin;

    protected Long parentId;

    protected String parentIds;

    protected String name;
    protected Integer sort;
    protected List children;
    private String type;
    private String target;
    private String icon;

    private Integer hasShow;

    private String permission;


}
