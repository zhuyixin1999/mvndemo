package edu.gd.mvndemo.test;

import edu.gd.mvndemo.utils.DBUtil;

import java.sql.*;

public class JDBCTest {

    public static void test1()  {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 1、加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2、获取数据库连接 jdbc:mysql://ip:port/database_name
            String url = "jdbc:mysql://localhost:3306/student_manager?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
            // mysql 用户名
            String username = "root";
            // mysql 密码
            String password = "thyme4joe";
            connection = DriverManager.getConnection(url, username, password);

            // 3、执行SQL语句
            String sql = "select * from student";
            // 返回预处理对象
            statement = connection.prepareCall(sql);

            // int i = statement.executeUpdate(); // 仅用于 Delete Update Insert
            resultSet = statement.executeQuery(); // 仅用于 Select

            // 4、处理sql执行结果
            while (resultSet.next())
            {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");

                System.out.println("name: " + name + " id: " + id);
            }
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            // 5、关闭所有连接
            try {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (statement != null)
                {
                    statement.close();
                }
                if (connection != null)
                {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    private static void test2() throws SQLException {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = connection.prepareCall("select * from student");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next())
        {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");

            System.out.println("name: " + name + " id: " + id);
        }
        DBUtil.close(resultSet, statement, connection);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        test1();
        test2();
    }

}
