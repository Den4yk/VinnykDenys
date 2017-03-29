package DAO;

import Model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO implements ModelDAO<Student> {
    private static final String INSERT_Q = "INSERT INTO students VALUES(?,?,?,?,?)";
    private static final String SELECT_Q = "SELECT * FROM students WHERE id=?";
    private static final String DELETE_Q = "DELETE FROM students WHERE id=?";

    public void add(Student obj) throws SQLException {
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(INSERT_Q);
        preparedStatement.setString(1, obj.getPib());
        preparedStatement.setInt(2, obj.getCourse());
        preparedStatement.setString(3, obj.getIdCode());
        preparedStatement.setString(4, obj.getPassportSeries());
        preparedStatement.setString(5, obj.getPassportNumber());
        preparedStatement.execute();
    }

    public Student get(long id) throws SQLException {
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        Student res = new Student();
        preparedStatement = connection.prepareStatement(SELECT_Q);
        preparedStatement.setLong(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        res.setPib(rs.getString(1));
        res.setCourse(rs.getInt(2));
        res.setIdCode(rs.getString(3));
        res.setPassportSeries(rs.getString(4));
        res.setPassportNumber(rs.getString(5));
        return res;
    }

    public void delete(long id) throws SQLException {
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(DELETE_Q);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    }
}
