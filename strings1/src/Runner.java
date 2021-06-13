import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        try {
            final String INPUT_CSV = "src/in.csv";
            Scanner sc = new Scanner(new FileReader(INPUT_CSV));
            final String BEFORE_SIGN = " ";
            final String AFTER_SIGN = " ";
            final String PLUS = BEFORE_SIGN + "+" + AFTER_SIGN;
            final String MINUS = BEFORE_SIGN + "-" + AFTER_SIGN;
            final String DELIMITER = ";";
            final String ERROR_LINES = "error-lines = ";
            final String RESULT_HEAD = "result(";
            final String RESULT_TAIL = ") = ";
            StringBuilder strResult = new StringBuilder();
            final int STRINGS_LENGTH = strResult.length();
            int errorLines = 0;
            double numResult = 0;

            while (sc.hasNextLine()){
                String[] words = sc.nextLine().split(DELIMITER);
                try{
                    int id = Integer.parseInt(words[0]);
                    double number = Double.parseDouble(words[id]);
                    numResult += number;
                    strResult.append(number > 0 ? PLUS: MINUS).append(Math.abs(number));
                }
                catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
                    errorLines++;
                }
            }
            if (strResult.length() > 0){
                final int SIGN_LENGTH = MINUS.length();
                final char CHAR_MINUS = '-';
                final char sign = strResult.charAt(1);
                strResult.delete(0, SIGN_LENGTH);
                if(sign == CHAR_MINUS){
                    strResult.insert(0, CHAR_MINUS);
                }
            }
            System.out.println(RESULT_HEAD + strResult + RESULT_TAIL + numResult);
            System.out.println(ERROR_LINES + errorLines);
        }
        catch (FileNotFoundException e) {
            System.err.println("No input file...");
        }
    }
}
