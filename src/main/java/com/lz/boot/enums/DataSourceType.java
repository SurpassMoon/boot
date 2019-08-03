package com.lz.boot.enums;

/**
 * @author li zhe
 * @ClassName DataSourceType.java
 * @Description 动态数据源类型 Master/Slave
 * @createTime 2019-08-02 11:30
 */
public enum  DataSourceType {

    MASTER("主库"),
    SLAVE("从库");

    private String desc;

    DataSourceType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }
}