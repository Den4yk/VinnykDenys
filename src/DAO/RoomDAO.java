package DAO;

import Model.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomDAO implements ModelDAO<Room> {
    private static final String INSERT_Q = "INSERT INTO rooms VALUES(?,?,?)";
    private static final String SELECT_Q = "SELECT * FROM rooms WHERE id=?";
    private static final String DELETE_Q = "DELETE FROM rooms WHERE id=?";

    public void add(Room obj) throws SQLException {
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement(INSERT_Q);
        preparedStatement.setString(1, obj.getNum());
        preparedStatement.setInt(2, obj.getMaxStudents());
        preparedStatement.setInt(3, obj.getFloor());
        preparedStatement.execute();
    }

    public Room get(long id) throws SQLException {
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        Room res = new Room();
        preparedStatement = connection.prepareStatement(SELECT_Q);
        preparedStatement.setLong(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        res.setNum(rs.getString(1));
        res.setMaxStudents(rs.getInt(2));
        res.setFloor(rs.getInt(3));
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
