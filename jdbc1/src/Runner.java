import by.gsu.epamlab.beans.Constants;
import by.gsu.epamlab.beans.NumLen;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        try {
            try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD); Statement statement = conn.createStatement()) {
                statement.executeUpdate(Constants.DELETE_FREQUENCIES);
                List<NumLen> frequencyList = new ArrayList<>();
                try (ResultSet resultSet = statement.executeQuery(Constants.SELECT_COORDINATES)) {
                    while (resultSet.next()) {
                        NumLen numLen = new NumLen(resultSet.getInt(Constants.LEN_IND), resultSet.getInt(Constants.NUM_IND));
                        frequencyList.add(numLen);
                        System.out.println(numLen);
                    }
                }

                try (PreparedStatement preparedStatement = conn.prepareStatement(Constants.INSERT_FREQUENCIES)) {
                    for (NumLen numLen :
                            frequencyList) {
                        preparedStatement.setInt(Constants.LEN_IND, numLen.getLen());
                        preparedStatement.setInt(Constants.NUM_IND, numLen.getNum());
                        preparedStatement.addBatch();
                    }
                    preparedStatement.executeBatch();
                }

                try (ResultSet resultSet = statement.executeQuery(Constants.SELECT_FREQUENCIES)) {
                    while (resultSet.next()) {
                        System.out.println(resultSet.getInt(Constants.LEN_IND) + Constants.DELIMITER + resultSet.getInt(Constants.NUM_IND));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}