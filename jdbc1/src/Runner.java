import by.gsu.epamlab.beans.Constants;
import by.gsu.epamlab.beans.Frequency;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        try {
            try (Connection conn = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD)) {
                Statement statement = conn.createStatement();
                statement.executeUpdate(Constants.DELETE);
                List<Frequency> frequencyList = new ArrayList<>();
                ResultSet resultSet = statement.executeQuery(Constants.SELECT);
                while (resultSet.next()) {
                    Frequency frequency = new Frequency(resultSet.getInt(1), resultSet.getInt(2));
                    frequencyList.add(frequency);
                    System.out.println(frequency);
                }

                PreparedStatement preparedStatement = conn.prepareStatement(Constants.INSERT);
                for (Frequency frequency :
                        frequencyList) {
                    preparedStatement.setInt(1, frequency.getLen());
                    preparedStatement.setInt(2, frequency.getNum());
                    preparedStatement.executeUpdate();
                }

                resultSet = statement.executeQuery(Constants.SELECT_LEN);
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + Constants.DELIMITER + resultSet.getInt(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}