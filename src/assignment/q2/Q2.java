package assignment.q2;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Q2 {
    public static void main(String[] args) {
        String paragraph = "This is a sample paragraph. It contains several sentences. Each sentence is separated by a period.";
        String[] words = paragraph.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split(" ");
        System.out.println(Arrays.toString(words));

        Map<String,Long> frequencyMap = Arrays.stream(words).filter(word->!word.isEmpty())
                .collect(groupingBy(word -> word, TreeMap::new, Collectors.counting()));
        System.out.println("Number of unique words: " + frequencyMap.size());
        System.out.println("Word frequencies: ");
        frequencyMap.forEach((word, count) -> System.out.println(word + ": " + count));
    }
}
