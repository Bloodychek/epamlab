import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        List<Trial> trials = new ArrayList<>();
        Collections.addAll(trials,
                new Trial("Audi", 10, 1),
                new Trial("BMW", 60, 70),
                new Trial("Nisan", 6, 9),
                new LightTrial("Opel", 66, 5),
                new LightTrial("Gely", 88, 100),
                new StrongTrial("Mercedes", 332, 55),
                new StrongTrial("Mazda", 12, 13),
                new ExtraTrial("Mitsubishi", 62, 1, 7),
                new ExtraTrial("Volkswagen", 78, 52, 2)
        );
        trials.forEach(System.out::println);
        System.out.println();

        System.out.println(trials.stream().filter(Trial::isPassed).count());

        Collections.sort(trials);
        trials.forEach(trial -> System.out.println(trial.sumMarks()));

        System.out.println();

        List<Trial> unpassedTrials = trials.stream().filter(trial -> !trial.isPassed()).map(trial -> {
            Trial newTrial = trial.clone();
            newTrial.cleanMarks();
            return newTrial;
        }).peek(System.out::println).toList();

        System.out.println(unpassedTrials.stream().noneMatch(Trial::isPassed));

        System.out.println();

        int[] trialArray = trials.stream().mapToInt(Trial::sumMarks).toArray();
        System.out.println(Arrays.stream(trialArray).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    }
}
