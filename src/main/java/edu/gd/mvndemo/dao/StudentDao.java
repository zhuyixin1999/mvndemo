package edu.gd.mvndemo.dao;

import edu.gd.mvndemo.entity.Student;
import edu.gd.mvndemo.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public static Student getStudent(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String name = resultSet.getString("name");
        String password = resultSet.getString("password");
        String sex = resultSet.getString("sex");
        String schoolDate = resultSet.getString("school_date");
        String major = resultSet.getString("major");
        String email = resultSet.getString("email");
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setPassword(password);
        student.setSchoolDate(schoolDate);
        student.setMajor(major);
        student.setSex(sex);
        student.setEmail(email);

        return student;
    }

    public static List<Student> getStudents()
    {
        List<Student> students = new ArrayList<Student>();
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareCall("select * from student");
            resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                Student student = getStudent(resultSet);
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DBUtil.close(resultSet, statement, connection);
        return students;
    }


    public static Student getStuById(String id)  {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from student where id = ?";
        PreparedStatement statement;
        ResultSet resultSet = null;
        Student student = null;
        try {
            statement = connection.prepareCall(sql);
            // 设置sql参数
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next())
            {
                student = getStudent(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }


    public static void main(String[] args) throws SQLException {
        Student student = getStuById("20162430637");
        System.out.println(student);
    }

}
