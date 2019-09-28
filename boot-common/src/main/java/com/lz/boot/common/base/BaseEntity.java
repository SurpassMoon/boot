package com.lz.boot.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author: 李喆
 * @Description:
 * @Date: 2019/9/24 12:21 下午
 */

@Data
public class BaseEntity {

    /** 自增 **/
    @TableId(value = "id",type = IdType.ID_WORKER_STR)
    private String id;
    /** 创建人**/
    public String creator;
    /** 创建时间**/
    @TableField(value ="create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public LocalDateTime createTime;
    /** 是否删除 **/
//    @TableLogic
//    public Integer isDelete;

}
