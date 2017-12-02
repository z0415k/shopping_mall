package com.shopping.mall.config.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 数据库数据源配置类
 *
 * @author zk
 */
@Configuration
@MapperScan(basePackages = "com.shopping.mall.mapper", sqlSessionTemplateRef = "shopMallSqlSessionTemplate")
public class ShopMallDataSoureceConfig {

    @Bean(name = "shopMallDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.shoppingMall")
    public DataSource shopMallDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "shopMallSqlSessionFactory")
    public SqlSessionFactory shopMallSqlSessionFactory(@Qualifier("shopMallDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "shopMallSqlSessionTemplate")
    public SqlSessionTemplate shopMallSqlSessionTemplate(@Qualifier("shopMallSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "test1TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("shopMallDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
