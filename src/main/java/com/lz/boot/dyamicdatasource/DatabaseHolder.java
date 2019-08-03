package com.lz.boot.dyamicdatasource;

import com.lz.boot.enums.DataSourceType;


/**
 * @ClassName DatabaseHolder.java
 * @Description 在当前线程保存DataSource
 * @author li zhe
 * @createTime 2019-08-03 10:06
 */
public class DatabaseHolder {

    private static ThreadLocal<DataSourceType> holder = new ThreadLocal<>();

    public static void setDatabaseSource(DataSourceType ds) {
        holder.set(ds);
    }

    public static DataSourceType getDatabaseSource() {
        return holder.get();
    }

    public static void clearDatabaseSource() {
        holder.remove();
    }
}