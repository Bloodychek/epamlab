import by.gsu.epamlab.Constants;
import by.gsu.epamlab.Segment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {

    public static void main(String[] args){
        List<Segment> segmentList = new ArrayList<>();
        try(Scanner sc = new Scanner(new FileReader(Constants.FILE_NAME))){
            Segment segment = null;
            while (sc.hasNext()){
                String line = sc.nextLine();
                String[] elements = line.split(Constants.REGEX);
                segment = new Segment(Math.round(getLen(elements)));
            }

            Collections.sort(segmentList, new Comparator<Segment>() {
                @Override
                public int compare(Segment o1, Segment o2) {
                    return o2.getNum() - o1.getNum();
                }
            });
            Collections.binarySearch(segmentList, segment);

            printList(segmentList);
        }

        catch (FileNotFoundException e){
            System.out.println(Constants.FILE_NOT_FOUND);
        }
    }

    private static double getLen(String[] elements){
        double firstTerm = Double.parseDouble(elements[0]) - Double.parseDouble(elements[2]);
        double secondTerm = Double.parseDouble(elements[1]) - Double.parseDouble(elements[3]);
        return Math.sqrt(firstTerm * firstTerm + secondTerm * secondTerm);
    }
    
    private static void printList(List<Segment> segmentList){
        for (Segment segment:
             segmentList) {
            System.out.println(segment);
        }
    }
}
