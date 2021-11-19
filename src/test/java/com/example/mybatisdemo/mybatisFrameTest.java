package com.example.mybatisdemo;

import javafx.application.Application;
import org.apache.ibatis.executor.SimpleExecutor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class mybatisFrameTest {


    private Configuration configuration;
    private Connection connection;
    private JdbcTransaction jdbcTransaction;

    @Before
    public void init() throws SQLException {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        InputStream in = mybatisFrameTest.class.getResourceAsStream("/mybatis.xml");
        SqlSessionFactory build = factoryBuilder.build(mybatisFrameTest.class.getResourceAsStream("/mybatis.xml"));
        configuration = build.getConfiguration();
        connection = DriverManager
            .getConnection("jdbc:mysql://82.156.5.108:3306/test", "root", "123456");
        jdbcTransaction = new JdbcTransaction(connection);

    }

    @Test
    public void simpleTest() throws SQLException {

        SimpleExecutor executor = new SimpleExecutor(configuration, jdbcTransaction);
        MappedStatement ms = configuration.getMappedStatement("com.example.mybatisdemo.Mapper.findAll");
        List<Object> list = executor.doQuery(ms,0, RowBounds.DEFAULT, SimpleExecutor.NO_RESULT_HANDLER, ms.getBoundSql(null));
        System.out.println(list.get(0));
    }

}
