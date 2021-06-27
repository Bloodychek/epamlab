import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {

    public static void main(String[] args) {
        final String ERROR_LINES = "error-lines = ";
        final String SUM = "sum = ";
        try{
            int errorLines = 0;
            double sum = 0;
            final String beginRegex = "(^index)([1-9]\\d*)";
            final String indexValueRegex = "^[0]\\.\\d+|^[1-9]\\d*";
            final String indexRegex = "^index";
            Pattern p1 = Pattern.compile(beginRegex);
            Pattern p2 = Pattern.compile(indexValueRegex);
            Pattern p3 = Pattern.compile(indexRegex);
            ResourceBundle rb = ResourceBundle.getBundle("in");
            Enumeration<String> keys = rb.getKeys();
            String key;
            while (keys.hasMoreElements()){
                key = keys.nextElement();
                Matcher m1 = p1.matcher(key);
                if(m1.matches()){
                    try{
                        var indexKeyStr= m1.group(2);
                        var indexValueStr = rb.getString(key);
                        if (p2.matcher(indexValueStr).matches()){
                            var valueKeyStr = "value" + indexKeyStr + indexValueStr;
                            var value = Double.parseDouble(rb.getString(valueKeyStr));
                            sum += value;
                        }
                        else{
                            errorLines ++;
                        }
                    }
                    catch (NumberFormatException | MissingResourceException e){
                        errorLines ++;
                    }
                }
                else{
                    if (p3.matcher(key).find()){
                        errorLines ++;
                    }
                }
            }

            System.out.println(SUM + sum);
            System.out.println(ERROR_LINES + errorLines);
        }
        catch (MissingResourceException e) {
            System.out.println("File not found...");
        }
    }
}
