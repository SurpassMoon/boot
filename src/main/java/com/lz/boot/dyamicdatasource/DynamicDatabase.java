package com.lz.boot.dyamicdatasource;

import com.lz.boot.enums.DataSourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.concurrent.atomic.AtomicInteger;

import static com.lz.boot.dyamicdatasource.DynamicDataSourceRegister.slaveDataSourceList;

/**
 * @ClassName DynamicDatabase.java
 * @Description 对多数据源进行动态分配
 * @author li zhe
 * @createTime 2019-08-03 10:06
 */
public class DynamicDatabase extends AbstractRoutingDataSource {

    private  Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AtomicInteger count = new AtomicInteger(0);

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType dataSourceType = DatabaseHolder.getDatabaseSource();

        if (dataSourceType==DataSourceType.MASTER){
            return dataSourceType;
        }else {
            int readSize = slaveDataSourceList.size();

            if (readSize==1){
                return slaveDataSourceList.get(0);
            }

            int num = count.getAndAdd(1);
            int lookupKey = readSize-1 > 0 ?  num %readSize : 0;
            String dbKey = (String) slaveDataSourceList.get(lookupKey);
            logger.info("db key is {}",dbKey);

            return dbKey;
        }


    }


}