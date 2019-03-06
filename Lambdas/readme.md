# Lambda expressions

## Serial factory - an introduction to streams and using lambda expressions to operate with them

#### Filtering
Given a serial numbers (one letter and three numbers) I want to show only such that starts with specified letter. Here is how can I do it without stream:
```java
List<String> cNumbers = new ArrayList<>();
        numbers.forEach(number -> {
            if(number.toUpperCase().startsWith("C"))
                cNumbers.add(number);
        });
cNumbers.forEach(System.out::println);
```
With stream I don't create any array and the code looks preety clear:
```java
numbers.stream()
       .filter(s -> s.toUpperCase().startsWith("B"))
       .sorted()
       .forEach(System.out::println);
```
#### Concating
My task is to concat (distinct) two given arrays of serial numbers, show them and their count.
```java
System.out.println(concatStream
       .distinct()
       .sorted()
       .peek(System.out::println)
       .count());
```

## Player factory - using *Predicate* and *Function* in methods

#### Predicate
```java
printPlayersByAge(players, "Players above 25:", player -> player.getAge() > 25);
printPlayersByAge(players, "Players 25 and under:", player -> player.getAge() <= 25);
```
