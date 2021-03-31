package hu.nive.ujratervezes.zarovizsga.housecup;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseCup {

    DataSource dataSource;

    public HouseCup(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public int getPointsOfHouse(String house) {
        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement ps = connection.prepareStatement("select sum(points_earned) from house_points where house_name=?")) {
            ps.setString(1, house);
            return getPointsOfHouseByPreparedStatement(ps);
        } catch (SQLException sqe) {
            throw new IllegalStateException("Cannot query", sqe);
        }


    }

    private int getPointsOfHouseByPreparedStatement(PreparedStatement ps) throws SQLException {
        try (
                ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
            throw new IllegalArgumentException("Cannot find house");
        }
    }


}
