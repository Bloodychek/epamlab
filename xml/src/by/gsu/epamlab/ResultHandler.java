package by.gsu.epamlab;

import by.gsu.epamlab.beans.Constants;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ResultHandler extends DefaultHandler {

    private enum ResultEnum {
        RESULTS, STUDENT, LOGIN, TESTS, TEST;
    }

    private List<Result> results = new ArrayList<>();
    private ResultEnum currentEnum;
    private String currentLogin;

    public List<Result> getResult() {
        return results;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentEnum = ResultEnum.valueOf(localName.toUpperCase());
        if (currentEnum == ResultEnum.TEST) {
            results.add(new Result(currentLogin, attributes.getValue(Constants.NAME_POS),
                    attributes.getValue(Constants.DATE_POS), attributes.getValue(Constants.MARK_POS)));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (currentEnum == ResultEnum.LOGIN) {
            String getStr = new String(ch, start, length).trim();
            if (!getStr.isEmpty()) {
                currentLogin = getStr;
            }
        }
    }
}