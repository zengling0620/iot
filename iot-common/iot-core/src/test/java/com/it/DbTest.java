package com.it;

import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.handler.EntityListHandler;
import cn.hutool.db.sql.SqlExecutor;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ZL
 * @menu todo
 * @date 2021/4/25 上午1:58
 */
public class DbTest {

    public Connection create() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/t_demo?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=CTT&&allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("数据库连接异常");
        }
    }

    @Test
    public void test() throws SQLException {
        Connection connection = create();
        List<Entity> entityList = SqlExecutor.query(connection, "select * from t_user where user_code = ?", new EntityListHandler(), "1");
        System.out.println("entityList = " + entityList);
        DbUtil.close(connection);
    }
}
