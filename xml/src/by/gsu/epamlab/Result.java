package by.gsu.epamlab;

import by.gsu.epamlab.beans.Constants;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class Result {
    private String login;
    private String test;
    private Date date;
    private int mark;

    private static final SimpleDateFormat OUTPUT_DATE_FORMAT = new SimpleDateFormat(Constants.DATE_FORMAT);

    public Result(String login, String test, Date date, int mark) {
        this.login = login;
        this.test = test;
        this.date = date;
        this.mark = mark;
    }

    public Result(String login, String test, String date, String mark) {
        this(login, test, Date.valueOf(date), (int)Double.parseDouble(mark) * Constants.TEN);
    }

    public Result() {
        this(null, null, null, 0);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String outMark() {
        return mark / Constants.TEN + Constants.DOT + mark % Constants.TEN;
    }

    private String getSimpleDate() {
        return OUTPUT_DATE_FORMAT.format(date);
    }

    @Override
    public String toString() {
        return login + Constants.DELIMITER + test + Constants.DELIMITER + getSimpleDate() + Constants.DELIMITER + outMark() + Constants.DELIMITER;
    }
}
