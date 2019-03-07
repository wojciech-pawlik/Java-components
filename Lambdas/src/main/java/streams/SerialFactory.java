package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SerialFactory {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList(
                "A451", "A342", "A535", "a345",
                "b532", "B123", "B341", "b999",
                "C444", "c314", "c213", "C901"
        );

        System.out.println("\n===================================================================\n");
        System.out.println(numbers);

        List<String> cNumbers = new ArrayList<>();
        numbers.forEach(number -> {
            if(number.toUpperCase().startsWith("C"))
                cNumbers.add(number);
        });

        System.out.println("\n===================================================================\n");
        cNumbers.forEach(System.out::println);

        System.out.println("\n===================================================================\n");
        numbers.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("B"))
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n===================================================================\n");
        numbers.stream()
                .filter(s -> s.toUpperCase().startsWith("B"))
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n===================================================================\n");
        Stream<String> ioStream = Stream.of("I012", "I214", "I642", "I444", "O253", "o532", "i436", "O325");
        Stream<String> inStream = Stream.of("I012", "i444", "i356", "i112", "n664", "N343", "n142");
        Stream<String> concatStream = Stream.concat(ioStream, inStream);
        System.out.println(concatStream
                .distinct()
                .sorted()
                .peek(System.out::println)
                .count());
    }
}
