import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        final String INPUT_CSV = "src/in.csv";
        final String PLUS = " + ";
        final String MINUS = " - ";
        String err = "error-lines = ";
        int errors = 0;
        String strResult = "result(";
        double doubleResult = 0;
        StringBuilder strings = new StringBuilder(strResult);
        final int STRINGS_LENGTH = strings.length();
        try {
            Scanner sc = new Scanner(new FileReader(INPUT_CSV));
            while (sc.hasNext()){
                String line = sc.nextLine();
                String[] sup = line.split(";");
                try{
                    int id = Integer.parseInt(sup[0]);
                    String[] element = sup[id].split("");
                    if(element[0].equals(MINUS.trim())){
                        strings.append(MINUS).append(Math.abs(Double.parseDouble(sup[id])));
                    }
                    else{
                        if (strings.length() != STRINGS_LENGTH)
                            strings.append(PLUS);
                        strings.append(Double.parseDouble(sup[id]));
                    }
                    doubleResult += Double.parseDouble(sup[id]);
                }
                catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
                    errors++;
                }
            }
            System.out.println(strings + ") = " + doubleResult);
            System.out.println(err + errors);
        }
        catch (FileNotFoundException e) {
            System.err.println("Input file not found");
        }
    }
}
