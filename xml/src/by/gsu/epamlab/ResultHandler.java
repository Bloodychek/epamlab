package by.gsu.epamlab;

import by.gsu.epamlab.beans.Constants;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ResultHandler extends DefaultHandler {

    private enum ResultEnum {
        RESULTS, STUDENT, LOGIN, TESTS, TEST;
    }

    private List<Result> results = new ArrayList<>();
    private ResultEnum currentEnum;
    private String currentLogin;
    Result currentResult = new Result();

    public List<Result> getResult() {
        return results;
    }

    private void setMark(String mark) {
        String[] marks = mark.split(Constants.REGULAR_DOT);
        currentResult.setMark(Integer.parseInt(marks[Constants.NULL]) * Constants.TEN + Integer.parseInt(marks[Constants.ONE]));
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentEnum = ResultEnum.valueOf(localName.toUpperCase());
        if (currentEnum == ResultEnum.TEST) {
            currentResult = new Result();
            currentResult.setLogin(currentLogin);
            currentResult.setTest(attributes.getValue(Constants.NAME_POS));
            currentResult.setDate(Date.valueOf(attributes.getValue(Constants.DATE_POS)));
            setMark(attributes.getValue(Constants.MARK_POS));
            results.add(currentResult);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String getStr = new String(ch, start, length).trim();
        if (!getStr.isEmpty()) {
            if (currentEnum != null && currentEnum == ResultEnum.LOGIN) {
                currentLogin = getStr;
            }
        }
    }
}