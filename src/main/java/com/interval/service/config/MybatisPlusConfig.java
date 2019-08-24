package com.interval.service.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.interval.service.model.view.DbConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class MybatisPlusConfig {
    @Bean(name = "dataSource")
    public DataSource dataSource(DbConfig dbConfig){
        DruidDataSource datasource = new DruidDataSource();
        //基本信息
        datasource.setUrl(dbConfig.getDbUrl());
        datasource.setUsername(dbConfig.getUsername());
        datasource.setPassword(dbConfig.getPassword());
        datasource.setDriverClassName(dbConfig.getDriverClassName());
        return datasource;
    }
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath*:mapper*//*.xml"));
        factoryBean.setTypeAliasesPackage("com.interval.service.model");
        PaginationInterceptor interceptor = new PaginationInterceptor();
        interceptor.setDialectType("mysql");
        //添加插件
        factoryBean.setPlugins(new Interceptor[]{interceptor});
        return factoryBean.getObject();
    }
    @Bean(name = "mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.interval.service.dao"); //需要扫描的DAO
        return mapperScannerConfigurer;
    }
}
