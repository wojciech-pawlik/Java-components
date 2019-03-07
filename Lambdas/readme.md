# Lambda expressions

Java 8 delivered us very powerful tool which makes our code cleaner and spares Hours of Fun. Instead of writing complex loops we can execute task writing one line.

## Serial factory - an introduction to streams and using lambda expressions to operate with them

#### Filtering
Given a serial numbers (one letter and three numbers) I want to show only such that starts with specified letter. Here is how can you do it without stream:
```java
List<String> cNumbers = new ArrayList<>();
numbers.forEach(number -> {
    if(number.toUpperCase().startsWith("C"))
        cNumbers.add(number);
});
cNumbers.forEach(System.out::println);
```
With stream you don't create any array and the code looks preety clear:
```java
numbers.stream()
       .filter(s -> s.toUpperCase().startsWith("B"))
       .sorted()
       .forEach(System.out::println);
```
#### Concating
The task is to concat (distinct) two given arrays of serial numbers, show them, and their count.
```java
System.out.println(concatStream
       .distinct()
       .sorted()
       .peek(System.out::println)
       .count());
```

## Player factory - using *Predicate* and *Function* in methods

#### Predicate
Argument of function can be another function. Predicate is a boolean-valued function of one argument. In this example condition is applied to every iteration in for-each loop.
```java
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
```
Now, to apply the condition correctly, use lambda expression:
```java
printPlayersByAge(players, "Players above 25:", player -> player.getAge() > 25);
printPlayersByAge(players, "Players 25 and under:", player -> player.getAge() <= 25);
```
The arguments are players and for every player it checks if the player fulfill condition.
#### Function
```java
private static void printPlayerDetails(List<Player> players,
                                       String detailText,
                                       Function<Player, String> details) {
    System.out.println("==============");
    System.out.println(detailText);
    players.stream().map(details).forEach(System.out::println);
}
```
The aim is to show list of players's last names, ages and nationalities in order of age. To sort the list, this is the simpliest way - using *Comparator* interface. Now, to show all needed details, use lambda expression.
```java
players.sort(Comparator.comparingInt(Player::getAge));
printPlayerDetails(players, "Last names, ages and nationalities", player -> player.getLastName() + ", "
        + player.getAge() + ", "
        + player.getNationality());
```

## Hobbies stack - map and flatmap
