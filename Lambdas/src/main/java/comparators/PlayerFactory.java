package comparators;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class PlayerFactory {
    public static void main(String[] args) {
        var players = getPlayers("players.csv");

        printPlayerDetails(players, "First names:", Player::getFirstName);

        players.sort(Comparator.comparingInt(Player::getAge));
        printPlayerDetails(players, "Last names, ages and nationalities", player -> player.getLastName() + ", "
                + player.getAge() + ", "
                + player.getNationality());

        players.sort((Comparator.comparing(Player::getLastName)));
        players.forEach(System.out::println);

        printPlayersByAge(players, "Players above 25:", player -> player.getAge() > 25);
        printPlayersByAge(players, "Players 25 and under:", player -> player.getAge() <= 25);
    }

    private static List<Player> getPlayers(String filePath) {
        var players = new ArrayList<Player>();

        try {
            var fr = new FileReader(filePath);
            var csvReader = new CSVReader(fr);
            String[] player;
            while((player = csvReader.readNext()) != null) {
                players.add(new Player(player[0], Integer.parseInt(player[1]), player[2], Integer.parseInt(player[3]), player[4]));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return players;
    }

    private static void printPlayersByAge(List<Player> players,
                                          String ageText,
                                          Predicate<Player> ageCondition) {
        System.out.println("==============");
        System.out.println(ageText);
        for(Player player : players) {
            if(ageCondition.test(player))
                System.out.println(player);
        }
    }

    private static void printPlayerDetails(List<Player> players,
                                           String detailText,
                                           Function<Player, String> details) {
        System.out.println("==============");
        System.out.println(detailText);
        players.stream().map(details).forEach(System.out::println);
    }
}
