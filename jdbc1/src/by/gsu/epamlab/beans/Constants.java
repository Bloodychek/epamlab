package by.gsu.epamlab.beans;

public class Constants {
    public static final String URL = "jdbc:mysql://localhost:3306/segments";
    public static final String USER = "root";
    public static final String PASSWORD = "1234";
    public static final String DELIMITER = ";";
    public static final String SELECT_FREQUENCIES = "Select len, num from frequencies where len > num";
    public static final String DELETE_FREQUENCIES = "delete from frequencies";
    public static final String SELECT_COORDINATES = "select abs(round(x2 - x1)) as len, count(*) as num from coordinates group by 1 order by 1";
    public static final String INSERT_FREQUENCIES = "insert frequencies(len, num) values (?, ?)";
    public static final int LEN_IND = 1;
    public static final int NUM_IND = 2;
}
