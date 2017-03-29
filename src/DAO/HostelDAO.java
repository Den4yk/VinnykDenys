package DAO;

import Model.Hostel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HostelDAO implements ModelDAO<Hostel> {
    private static final String INSERT_Q = "INSERT INTO hostels VALUES(?,?,?)";
    private static final String SELECT_Q = "SELECT * FROM hostels WHERE id=?";
    private static final String DELETE_Q = "DELETE FROM hostels WHERE id=?";

    public void add(Hostel obj) throws SQLException {
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(INSERT_Q);
        preparedStatement.setInt(1, obj.getNum());
        preparedStatement.setString(2, obj.getAdress());
        preparedStatement.setString(3, obj.getPibManager());
        preparedStatement.execute();
    }

    public Hostel get(long id) throws SQLException {
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        Hostel res = new Hostel();
        preparedStatement = connection.prepareStatement(SELECT_Q);
        preparedStatement.setLong(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        res.setNum(rs.getInt(1));
        res.setAdress(rs.getString(2));
        res.setPibManager(rs.getString(3));
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
