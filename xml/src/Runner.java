import by.gsu.epamlab.beans.Constants;
import by.gsu.epamlab.Result;
import by.gsu.epamlab.ResultHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventFactory;
import java.io.File;
import java.io.IOException;

public class Runner {

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            ResultHandler handler = new ResultHandler();
            reader.setContentHandler(handler);
            reader.parse(Constants.PATH);

            for (Result result : handler.getResult()) {
                System.out.println(result);
            }
        } catch (IOException | SAXException e) {
            System.out.println(e.getMessage());
        }
    }
}
