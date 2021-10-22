package com.it;

import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;
import cn.hutool.db.Entity;
import cn.hutool.db.handler.EntityListHandler;
import cn.hutool.db.handler.RsHandler;
import cn.hutool.db.sql.Query;
import cn.hutool.db.sql.SqlExecutor;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ZL
 * @menu todo
 * @date 2021/4/25 上午1:58
 */
public class DbTest {

    public DataSource create() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/t_demo?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=CTT&&allowPublicKeyRetrieval=true");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Test
    public void test() throws SQLException {
        String sql = "select * from t_user where user_code = ?";
        Connection connection = create().getConnection();
        Db db = Db.use(create());
        DbUtil.close(connection);
        Entity entity = db.queryOne(sql, "1");
        System.out.println("entity = " + entity);
        List<User> userList = db.query(sql, User.class, 1);
        System.out.println("userList = " + userList);

        Query query = new Query();
        query.setTableNames("t_user");
    }
}
