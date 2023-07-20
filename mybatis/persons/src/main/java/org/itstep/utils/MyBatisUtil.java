package org.itstep.utils;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.itstep.mapper.AddressMapper;
import org.itstep.mapper.PersonMapper;

import javax.sql.DataSource;

public class MyBatisUtil {
    public static final String DRIVER = "org.h2.Driver";
    public static final String URL = "jdbc:h2:file:C:/Users/gk/IdeaProjects/mybatis/persons/src/main/resources/data";
    public static final String USERNAME = "";
    public static final String PASSWORD = "";
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory buildSqlSessionFactory() {
        DataSource dataSource = new PooledDataSource(DRIVER, URL, USERNAME, PASSWORD);
        Environment environment = new Environment("Development", new JdbcTransactionFactory(), dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(PersonMapper.class);
        configuration.addMapper(AddressMapper.class);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(configuration);
        return factory;
    }
}
