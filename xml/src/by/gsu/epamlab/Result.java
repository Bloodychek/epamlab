package by.gsu.epamlab;

import by.gsu.epamlab.beans.Constants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Result {
    private String login;
    private String test;
    private Date date;
    private int mark;

    private static final SimpleDateFormat FORMAT_DATE = new SimpleDateFormat("dd.MM.yyyy");

    public Result(String login, String test, Date date, int mark) {
        this.login = login;
        this.test = test;
        this.date = date;
        this.mark = mark;
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

    private String outDate() {
        return FORMAT_DATE.format(date);
    }

    @Override
    public String toString() {
        return login + Constants.DELIMITER + test + Constants.DELIMITER + outDate() + Constants.DELIMITER + outMark() + Constants.DELIMITER;
    }
}
