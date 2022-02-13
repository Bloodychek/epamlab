package by.gsu.epamlab;

import by.gsu.epamlab.beans.Constants;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ResultHandler extends DefaultHandler {

    private enum ResultEnum {
        RESULTS, STUDENT, LOGIN, TESTS, TEST;
    }

    private List<Result> results = new ArrayList<>();
    private Result currentResult = new Result();
    private ResultEnum currentEnum;
    private String currentLogin;

    public List<Result> getResult() {
        return results;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentEnum = ResultEnum.valueOf(localName.toUpperCase());
        if (currentEnum == ResultEnum.TEST) {
            currentResult.setLogin(currentLogin);
            currentResult.setTest(attributes.getValue(Constants.NAME_POS));
            try {
                currentResult.setDate(new SimpleDateFormat(Constants.FORMAT).parse(attributes.getValue(Constants.DATE_POS)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            currentResult.setMark(Integer.parseInt(String.valueOf(Constants.MARK_POS)));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String getStr = new String(ch, start, length).trim();
        if (currentEnum != null) {
            if (currentEnum == ResultEnum.LOGIN) {
                currentLogin = getStr;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (currentEnum == ResultEnum.TEST) {
            results.add(currentResult);
        }
    }
}