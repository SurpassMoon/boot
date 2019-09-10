package com.lz.boot.common;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 测试
 * @author lizhe
 * @date
 */
@Data
public class BaseEntity {

    private Integer id;

    private Integer createUser;

    private LocalDateTime createDate;

    @TableLogic
    private Integer isDelete;

}
