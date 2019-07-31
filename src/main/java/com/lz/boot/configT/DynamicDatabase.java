package com.lz.boot.configT;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDatabase extends AbstractRoutingDataSource {

    private  Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected Object determineCurrentLookupKey() {
        logger.info("当前数据源是：{}", DatabaseHolder.getDatabaseSource());
        return DatabaseHolder.getDatabaseSource();
    }

}