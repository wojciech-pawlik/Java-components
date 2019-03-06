package flatmap;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HobbiesStack {
    public static void main(String[] args) {
        List<Person> people = getPeople("people.csv");
        System.out.println("People:");
        people.forEach(System.out::println);
        System.out.println("\n===================================================================\n");
        System.out.println("Hobbies for every person: (list of lists)");
        people.stream().map(Person::getHobbies).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("\n===================================================================\n");
        System.out.println("All hobbies of given people: (list of strings)");
        people.stream().flatMap(person -> person.getHobbies().stream()).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }

    private static List<Person> getPeople(String filePath) {
        var people = new ArrayList<Person>();

        try {
            var fr = new FileReader(filePath);
            var csvReader = new CSVReader(fr);
            String[] person;
            while((person = csvReader.readNext()) != null) {
                people.add(new Person(person[0], Integer.parseInt(person[1]), Arrays.stream(person).skip(2).collect(Collectors.toList())));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return people;
    }
}
