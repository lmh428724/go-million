package com.sg.learn.gomillion.article.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author healy
 * @since 2021-03-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("article_read")
@ApiModel(value="ArticleRead对象", description="")
public class ArticleRead implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId("id")
    private String id;

    @ApiModelProperty(value = "文章序号")
    @TableField("article_id")
    private String articleId;

    @ApiModelProperty(value = "当日起始阅览量")
    @TableField("original_count")
    private String originalCount;

    @ApiModelProperty(value = "当日最终阅览量")
    @TableField("final_count")
    private String finalCount;

    @ApiModelProperty(value = "当日增加的阅览量")
    @TableField("read_add")
    private String readAdd;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField("update_time")
    private Date updateTime;


    public static final String ID = "id";

    public static final String ARTICLE_ID = "article_id";

    public static final String ORIGINAL_COUNT = "original_count";

    public static final String FINAL_COUNT = "final_count";

    public static final String READ_ADD = "read_add";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

}
