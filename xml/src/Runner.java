import by.gsu.epamlab.beans.Constants;
import by.gsu.epamlab.Result;
import by.gsu.epamlab.ResultHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Runner {

    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();

            ResultHandler resultHandler = new ResultHandler();
            parser.parse(new File(Constants.PATH), resultHandler);

            for (Result result :
                    resultHandler.getResult()) {
                System.out.println(result);
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new IllegalArgumentException();
        }
    }
}
