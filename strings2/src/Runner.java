import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {

    public static void main(String[] args) {
        final String ERROR_LINES = "error-lines = ";
        final String SUM = "sum = ";
        try {
            ResourceBundle rb = ResourceBundle.getBundle("in");
            Enumeration<String> keys = rb.getKeys();
            final String KEY_REG_EXP = "index(.*)";
            final String NUM_REG_EXP = "[1-9]\\d*";
            Pattern p1 = Pattern.compile(KEY_REG_EXP);
            Pattern p2 = Pattern.compile(NUM_REG_EXP);
            final int TAIL_INDEX = 1;
            final String VALUE = "value";
            String jStr = "";
            String iStr = "";
            int errorLines = 0;
            double sum = 0;
            String key;
            while (keys.hasMoreElements()) {
                key = keys.nextElement();
                Matcher keyMatcher = p1.matcher(key);
                if (keyMatcher.matches()) {
                    jStr = keyMatcher.group(TAIL_INDEX);
                    jStr = rb.getString(key).trim();
                    Matcher iMatcher = p2.matcher(iStr);
                    Matcher jMatcher = p2.matcher(jStr);
                    iStr = iMatcher.group(TAIL_INDEX);
                    iStr = rb.getString(key).trim();
                    if (iMatcher.matches() && jMatcher.matches()) {
                        String valueIJ = VALUE + iStr + jStr;
                        try {
                            Double value = Double.parseDouble(rb.getString(valueIJ));
                            sum += value;
                        } catch (NumberFormatException | MissingResourceException e) {
                            errorLines++;
                        }
                    } else {
                        errorLines++;
                    }
                }
            }

            System.out.println(SUM + sum);
            System.out.println(ERROR_LINES + errorLines);

        } catch (MissingResourceException e) {
            System.out.println("File not found...");
        }
    }
}