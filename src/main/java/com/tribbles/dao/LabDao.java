package com.tribbles.dao;

import com.tribbles.config.JDBCConfiguration;
import com.tribbles.model.Lab;
import com.tribbles.model.Tribble;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DAO for Tribbles used to perform CRUD operations using JDBC
 */
public class LabDao implements InterfaceDao<Lab, Integer>{

    @Override
    public int save(Lab lab) {
        try {
            String sql = "insert into labs values (nextval('labs_sequence') , ? , ?)";
            PreparedStatement preparedStatement = JDBCConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, lab.getName());
            preparedStatement.setString(2, lab.getPlanet());
            return preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    @Override
    public Lab read(Integer id) {
        try {
            String sql = "select * from labs where id = ?";
            PreparedStatement preparedStatement = JDBCConfiguration.getInstance().getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            return new Lab(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

    @Override
    public int update(Lab lab) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
