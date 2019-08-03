package com.lz.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.util.Map;

@SpringBootTest
class BootApplicationTests {

    @Autowired
    private Environment evn;

//    @Autowired
    private Binder binder;

    @Test
    void contextLoads() {

        binder = Binder.get(evn);

        String typeStr = evn.getProperty("spring.datasource");
        Map map = binder.bind("spring.datasource", Map.class).get();

//        Map config, properties, defaultConfig = binder.bind("spring.datasource", Map.class).get();

        ConfigurationPropertySource source = new MapConfigurationPropertySource(map);

        System.out.println(map);

    }

}
