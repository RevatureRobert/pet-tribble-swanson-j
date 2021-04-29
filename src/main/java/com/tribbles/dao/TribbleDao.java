package com.tribbles.dao;

import com.tribbles.config.JDBCConfiguration;
import com.tribbles.model.Lab;
import com.tribbles.model.Tribble;
import com.tribbles.service.LabService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO for Tribbles used to perform CRUD operations using JDBC
 */
public class TribbleDao implements InterfaceDao<Tribble, Integer>{

    @Override
    public int save(Tribble tribble) {
        try {
            String sql = "insert into tribbles values (nextval('tribbles_sequence') , ? , ?, ?)";
            PreparedStatement preparedStatement = JDBCConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, tribble.getName());
            preparedStatement.setString(2, tribble.getColor());
            preparedStatement.setInt(3, tribble.getLab().getId());
            return preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    @Override
    public Tribble read(Integer id) {
        try {
            String sql = "select * from tribbles where id = ?";
            PreparedStatement preparedStatement = JDBCConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            return new Tribble(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    new LabService().read(resultSet.getInt(4)));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public int update(Tribble tribble) {
        try {
            String sql = "update tribbles set name = ?, color = ?, lab_id = ? where tribbles.id = ?";
            PreparedStatement preparedStatement = JDBCConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, tribble.getName());
            preparedStatement.setString(2, tribble.getColor());
            preparedStatement.setInt(3, tribble.getLab().getId());
            preparedStatement.setInt(3, tribble.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(Integer id) {
        try {
            String sql = "delete from tribbles where id = ?";
            PreparedStatement preparedStatement = JDBCConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }
}
