package com.niit.config;

import com.niit.mapper.StudentMapper;
import com.niit.model.Gender;
import com.niit.typehandler.GenderTypeHandler;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

public class MyBatisUtil {

    public static SqlSessionFactory getSession()
    {
        DataSource ds=new PooledDataSource(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/studentdb",
                "root",
                "niit1234"
        );
        Environment ev=new Environment("develpment",
                new JdbcTransactionFactory(), ds);
        Configuration config=new Configuration(ev);
        config.addMapper(StudentMapper.class);
        config.getTypeHandlerRegistry().register(
                GenderTypeHandler.class);
        return new SqlSessionFactoryBuilder().build(config);

    }

}
