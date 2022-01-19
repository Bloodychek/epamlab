package by.gsu.epamlab.beans;

public class Constants {
    public static final String URL = "jdbc:mysql://localhost:3306/segments";
    public static final String USER = "root";
    public static final String PASSWORD = "1234";
    public static final String DELIMITER = ";";
    public static final String SELECT_LEN = "Select len, num from frequencies where len > num";
    public static final String DELETE = "delete from frequencies where IdFrequencies > 0";
    public static final String SELECT = "select abs(round(x2 - x1)) as len, count(*) as num from coordinates group by len order by len";
    public static final String INSERT = "insert frequencies(len, num) values (?, ?)";
}
