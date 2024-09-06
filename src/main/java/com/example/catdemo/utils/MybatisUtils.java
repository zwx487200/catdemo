package com.example.catdemo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;
    static{
        try {
            //访问mybatis 读取User数据
            //mybatis全局配置文件名定义
            String resource = "mybatis-config.xml";
            //读取这个resource表示的文件并将其转化为输入流
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     *既然有了SqlSessionFactory顾名思义,我们可以从其中获得SqlSession的实例了
     * Session完全包含了面向数据库执行sql命令的所有方法
     * SIMPLE,
     *     REUSE,
     *     BATCH;
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(ExecutorType.SIMPLE);
    }
}

