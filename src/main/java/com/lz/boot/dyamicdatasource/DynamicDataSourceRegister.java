package com.lz.boot.dyamicdatasource;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.boot.context.properties.source.ConfigurationPropertyNameAliases;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.MapConfigurationPropertySource;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName DynamicDataSourceRegister.java
 * @author li zhe
 * @Description 动态注册数据源  启动时加 @Import(DynamicDataSourceRegister.class)
 * @createTime 2019-08-02 11:40
 */

public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {


    public static final String SPRING_DATASOURCE_SLAVE = "spring.datasource.slave";
//    public static final String SPRING_DATASOURCE_MASTER_TYPE = "spring.datasource.master.type";
    public static final String SPRING_DATASOURCE_MASTER = "spring.datasource.master";
    //动态数据源池
    private Map<String, DataSource> customDataSources = new HashMap<String, DataSource>();

    /**
     * springboot2.0后获取的配置文件的方式 之前的RelaxedDatabinder已无法使用
     * 通过最后额setEnvironment()来初始化
     */
    private Binder binder;
    private Environment env;

    //动态数据源标识存储
    public static List slaveDataSourceList = new ArrayList();

    Class<? extends DataSource> clazz;

    /**
     * 别名
     */
    private final static ConfigurationPropertyNameAliases aliases = new ConfigurationPropertyNameAliases();

    /**
     * 由于部分数据源配置不同，所以在此处添加别名，避免切换数据源出现某些参数无法注入的情况
     */
    static {
        aliases.addAliases("url", new String[]{"jdbc-url"});
        aliases.addAliases("username", new String[]{"user"});
    }


    /**
     * 可能因加载方式问题倒是初始化失败 不能用 待研究
     * @param annotationMetadata
     * @param beanDefinitionRegistry
     */
//    @Bean(name = "writeDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.write")
//    public DataSource writeDataSource(){
//        String typeStr = env.getProperty("spring.datasource.master.type");
//        return DataSourceBuilder.create().type(getDataSourceClass(typeStr)).build();
//    }


    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //bean 定义器
        GenericBeanDefinition datasource = new GenericBeanDefinition();
        //定义bean的类型
        datasource.setBeanClass(DynamicDatabase.class);
        //注入bean参数
        MutablePropertyValues mpv = datasource.getPropertyValues();
        //添加默认数据源
        mpv.add("defaultTargetDataSource", creatDefaultTargetDataSource());
        //注入其他数据源
        creatTargetDataSources();
        mpv.add("targetDataSources", customDataSources);
        beanDefinitionRegistry.registerBeanDefinition("datasource", datasource);

    }

    private void creatTargetDataSources() {
        List<Map> slaves = binder.bind(SPRING_DATASOURCE_SLAVE, Bindable.listOf(Map.class)).get();

        for (int i = 0; i < slaves.size(); i++) {
            Map slaveProperties = slaves.get(i);
            clazz = getDataSourceClass((String) slaveProperties.get("type"));
            DataSource slave = bind(clazz, slaveProperties);
            String key = (String) slaveProperties.get("key");
            customDataSources.put(key, slave);
            slaveDataSourceList.add(key);
        }

    }

    private Object creatDefaultTargetDataSource() {
        Map<String,String> defauleDataSourceProperties = binder.bind(SPRING_DATASOURCE_MASTER, Map.class).get();
        clazz = getDataSourceClass(defauleDataSourceProperties.get("type"));
        return bind(clazz, defauleDataSourceProperties);
    }

    private Class<? extends DataSource> getDataSourceClass(String type) {
        Class<? extends DataSource> dataSourceClass;
        try {
            if (StringUtils.hasLength(type)) {
                // 字符串不为空则通过反射获取class对象
                dataSourceClass = (Class<? extends DataSource>) Class.forName(type);
            } else {
                // 默认为hikariCP数据源，与springboot默认数据源保持一致
                dataSourceClass = HikariDataSource.class;
            }
            return dataSourceClass;
        } catch (Exception e) {
            throw new IllegalArgumentException("can not resolve class with type: " + type); //无法通过反射获取class对象的情况则抛出异常，该情况一般是写错了，所以此次抛出一个runtimeexception
        }
    }


    private <T extends DataSource> T bind(Class<T> clazz, Map properties) {
        ConfigurationPropertySource source = new MapConfigurationPropertySource(properties);
        Binder binder = new Binder(new ConfigurationPropertySource[]{source.withAliases(aliases)});
        // 通过类型绑定参数并获得实例对象
        return binder.bind(ConfigurationPropertyName.EMPTY, Bindable.of(clazz)).get();
    }


    @Override
    public void setEnvironment(Environment environment) {
        this.env = environment;
        binder = Binder.get(env);
    }
}
