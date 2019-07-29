package com.lz.boot.configT;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDatabase extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseHolder.getDatabaseSource();
    }

}