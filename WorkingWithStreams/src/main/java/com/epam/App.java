package com.epam;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        Stream.generate(() -> "sasi").limit(10).forEach(System.out::println);

        //From a list of strings, print all strings containing the letter 'a'.
        List<String> stringsList = Arrays.asList("sasi","apple","ant");
        stringsList.stream().filter(string -> string.startsWith("a")).forEach(System.out::println);

        //Find the sum of all even numbers from an integer list.
        Integer sumValue = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .filter(number -> number % 2==0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sumValue);

        Optional<Integer> value = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .filter(number -> number % 2 == 0)
                .reduce(Integer::sum);
        System.out.println(value.get());

        int value1 = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .filter(number -> number % 2 == 0)
                .reduce(0,(a,b) -> a + b);
        System.out.println(value1);

        //Calculate the count of unique characters in a string.
        String string = "this is string";
        string.chars()
                .mapToObj(character -> (char)character)
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(Function.identity(),Collectors.counting()), entry ->entry.entrySet()
                        .stream()
                        .filter(character -> character.getValue() == 1)
                        .map(Map.Entry::getKey)))
                .forEach(System.out::println);

        //print the largest length of word in string
        String string1 = "Welcome to java";

        Arrays.stream(string1.split(" ")).sorted(Comparator.comparingInt(String::length).reversed())
                .limit(1)
                .forEach(System.out::println);

        Map<String,Long> total = Arrays.stream(string1.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(
                total.entrySet()
                        .stream()
                        .map(entry -> entry.getKey())
                        .max(Comparator.comparing(String::length))
        );


        //Average of List of Doubles: Compute the average of a list of doubles.
        List<Double> doubleValues = Arrays.asList(3.5,2.5,4.5,5.5,6.5,7.0);
        double doubleValue = doubleValues.stream()
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();
        System.out.println(doubleValue);

        double doublevalue = doubleValues.stream().collect(Collectors.averagingDouble(Double::doubleValue));
        System.out.println(doublevalue);

        //Grouping by Length: Group a list of strings by their lengths.
        List<String> stringList = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
        Map<Integer, List<String>> strings = stringList.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(strings);

        // Partition a list of integers into two groups: odd and even numbers.
        Map<Boolean,List<Integer>> numbers = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .collect(Collectors.partitioningBy(number ->number % 2 == 0));
        System.out.println(numbers);

        //Counting Words Starting with 'S': From a list of words, count words that start with the letter 'S'.
        long words = Arrays.asList("apple", "sasi", "orange", "shasank", "kiwi")
                .stream()
                .map(String::toLowerCase)
                .filter(word -> word.startsWith("s"))
                .count();
        System.out.println(words);

        //Filter and Join Strings: Filter a list of strings and concatenate them into a single string.
        String strings1 = Arrays.asList("apple", "sasi", "orange", "shasank", "kiwi")
                .stream()
                .collect(Collectors.joining(",","#","#"));
        System.out.println(strings1);

        //Square of Even Numbers: Find the squares of all even numbers from a list of integers.
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .filter(number -> number % 2 == 0)
                .map(number -> number*number)
                .forEach(System.out::println);

        //Sorting Strings by Length: Sort a list of strings by their lengths.
        List<String> listOfString = Arrays.asList("apple", "shasank Gadipilli", "orange", "shasank", "kiwi")
                .stream()
                .sorted((word1,word2) -> {
                    if(word1.length() > word2.length()){
                        return 1;
                    } else if (word1.length() < word2.length()) {
                        return -1;
                    }
                    return 0;
                })
                .collect(Collectors.toList());
        System.out.println(listOfString);

        Arrays.asList("apple", "shasank Gadipilli", "orange", "shasank", "kiwi")
                .stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);

        // Find the maximum and minimum values from a list of integers.
        Optional<Integer> minNumber = Stream.of(2,1,3,4,22,0,45,77,89,98)
                .sorted()
                .findFirst();

        Optional<Integer> maxNumber = Stream.of(2,1,3,4,22,0,45,77,89,98)
                .sorted(Comparator.reverseOrder())
                .findFirst();

        System.out.println("min: "+minNumber+" max: "+maxNumber);

        //Find Sublist: Check if one list is a sublist of another list
        List.of(1,2,3,4,5).
                stream()
                        .allMatch(element -> List.of(2,3,4).contains(element));


        //Distinct Elements: Get a list of unique elements from a list of integers.

        Stream.of(1,2,3,3,4,4,5,3,3,9,9,10)
                .distinct()
                .forEach(System.out::println);

        //Counting Elements: Count occurrences of each element in a list.
        Stream.of(1,2,3,4,4,3,3,2,1,10,9)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach((key,keyValue) -> System.out.println(key+" -> "+keyValue));

        //Concatenating Lists: Concatenate two lists into one.
        Stream.concat(Stream.of(1,2,3,4),Stream.of(5,6,7,8))
                .collect((Collectors.toList()))
                .forEach(System.out::println);

        //Grouping by Starting Letter: Group a list of strings by their starting letters.
        Stream.of("sasi","apple","ant","world","elephant","shasank","sreeja")
                .collect(Collectors.groupingBy(word -> word.charAt(0)))
                .forEach((key,keyValue) -> System.out.println(key+" -> "+keyValue));

        //Sum of Squares of Numbers: Find the sum of squares of numbers from a list of integers.
        System.out.println(
                Stream.of(1,2,3)
                        .map(element -> element*element)
                        .mapToInt(Integer::intValue)
                        .sum()
        );

        System.out.println(
                Stream.of(1,2,3)
                        .map(element -> element*element)
                        .reduce(Integer::sum)
        );

        System.out.println(
                Stream.of(1,2,3)
                        .map(element -> element*element)
                        .reduce(0,(a,b) -> a + b)
        );

        //Check for Palindromes: Determine if a list of strings contains palindromes.
        Stream.of("ant","pop","push","tenet")
                .filter(App::isPalindrome)
                .forEach(System.out::println);

        //Mapping List of Strings: Convert a list of strings to uppercase.
        Stream.of("ant","sasi","apple")
                .map(String::toUpperCase)
                .forEach(System.out::println);

        //Multiplying List Elements: Multiply each element of a list by a given factor.
        int factor= 2;
        Stream.of(1,2,3,4)
                .map(element -> element * factor)
                .forEach(System.out::println);

        //Check for Prime Numbers: Check if a list of integers contains prime numbers.
        Stream.of(1,2,3,4,5,6)
                .filter(App::isPrime)
                .forEach(System.out::println);

        //Reduce List of Strings: Reduce a list of strings to a single concatenated string.
        System.out.println(

                Stream.of("ant","apple","orange")
                        .reduce("",(word1,word2)-> word1+" "+word2)
        );
        System.out.println(
                Stream.of("ant","apple","orange")
                        .collect(Collectors.joining(",","[","]"))
        );

        //create a BinaryOperator
        BinaryOperator<Integer> function = (a,b) -> a+b;
        System.out.println(function.apply(1,2));

        //create a BiConsumer
        BiConsumer<Integer,Integer> biConsumer = (a,b) ->System.out.println(a+b);
        biConsumer.accept(1,1);


        //Mapping Object to Another Object: Map a list of Person objects to a list of their respective ages.
        List.of(new Person("Vamsi",20),new Person("sasi",20),new Person("siddu",22),new Person("sreeja",21),new Person("lavanya",22))
                .stream()
                .collect(Collectors.groupingBy(Person::getAge))
                .forEach((key,values) -> System.out.println(key+" -> "+values));

        List.of(new Person("Vamsi",20),new Person("sasi",20),new Person("siddu",22),new Person("sreeja",21),new Person("lavanya",22))
                .stream()
                .collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getAge,Collectors.toList())))
                .forEach((key,values) -> System.out.println(key+" -> "+values));

        //Checking for Empty Strings: Check if a list of strings contains empty strings.
        System.out.println(
                List.of("ant","apple","","orange","  ")
                        .stream()
                        .filter(String::isBlank)
                        .collect(Collectors.counting())
        );

        //Finding Average Length of Strings: Calculate the average length of strings from a list.
        System.out.println(
                List.of("ant","apple","orange","pineapple")
                        .stream()
                        .map(String::length)
                        .collect(Collectors.averagingInt(Integer::intValue))
//                        .mapToDouble(Integer::doubleValue)
//                        .reduce(0.0,(a,b) -> a+b));
        );

        //Filtering with Predicate: Use a custom predicate to filter a list of elements.
        Predicate<String> customPredicate = (word) -> word.contains("s");
        Stream.of("ant","sasi","siddu","ravi")
                .filter(customPredicate)
                .forEach(System.out::println);

        //Merging Lists: Merge two lists removing duplicates.
        Stream.concat(Stream.of(1,2,3,3,4),Stream.of(1,2,2,3,4,4))
                .distinct()
                .forEach(System.out::println);

        //Removing Duplicates from List: Remove duplicates from a list of strings.
        Stream.of("ant","sasi","siddu","ravi","Sasi","ravi")
                .map(String::toLowerCase)
                .distinct()
                .forEach(System.out::println);

        System.out.println(
                Stream.of("ant","sasi","siddu","ravi","Sasi","ravi")
                        .collect(Collectors.toCollection(() -> new TreeSet<>(String.CASE_INSENSITIVE_ORDER)))
        );

        //Partitioning Strings by Length: Partition a list of strings into two lists based on their length.
        System.out.println(
                Stream.of("ant","sasi","siddu","ravi")
                        .collect(Collectors.partitioningBy(word -> word.length() % 2 == 0))
        );

        //Finding Maximum String Length: Find the maximum length among strings in a list.
        System.out.println(
                Stream.of("ant","sasi","siddu","ravi")
                        .max((o1, o2) -> {
                            if (o1.length() > o2.length()) {
                                return 1;
                            } else if (o1.length() < o2.length()) {
                                return -1;
                            }
                            return 0;
                        })
        );

        System.out.println(
                Stream.of("ant","sasi","siddu","ravi")
                        .collect(Collectors.maxBy(Comparator.comparingInt(String::length)))
        );

        System.out.println(
                Stream.of("ant","sasi","siddu","ravi")
                        .collect(Collectors.maxBy(Comparator.naturalOrder()))
        );

        System.out.println(
                Stream.of("ant","sasi","siddu","ravi")
                        .max(Comparator.naturalOrder())
        );

        //Combining Multiple Streams: Combine elements from multiple streams into a single stream.
        Stream.concat(Stream.of("ant","sasi","siddu","ravi"),Stream.of("shasank","gadipilli"))
                .forEach(System.out::println);

        //Find the Second Largest Element: Find the second largest element in a list of integers.
        System.out.println(
                List.of(1,234,343,99,88,4444,1,2,2,3,33,44,55,123,543)
                        .stream()
                        .distinct()
                        .sorted(Comparator.reverseOrder())
                        .skip(1)
                        .findFirst()
        );

        //Joining Strings with Delimiter: Join a list of strings with a delimiter.
        System.out.println(
                Stream.of("ant","apple","orange")
                        .collect(Collectors.joining(","))
        );

        //Checking for Empty Lists: Check if a list of lists is empty.
        System.out.println(
                List.of(List.of("apple", "banana"), List.of("orange", "grape"), List.of())
                        .stream()
                        .anyMatch(List::isEmpty)
        );

        Map<String,Integer> map = Map.of("sasi",1,"shasank",2,"apple",4,"ant",5);
        map.entrySet()
                .stream()
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        //Splitting Strings: Split a string into a list of characters
        "shasank".chars()
                .mapToObj(character -> (char)character)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        //Remove Elements Based on Condition: Remove elements from a list that satisfy a given condition.
        System.out.println(
                List.of(1,2,3,4,5,6)
                        .stream()
                        .filter(number -> number % 2 == 0)
                        .collect(Collectors.toList())
        );

        //Check for Non-Empty Strings: Check if a list of strings contains only non-empty strings.
        System.out.println(
                List.of("ant","apple","ant","")
                        .stream()
                        .allMatch(String::isEmpty)
        );

        //Check for Empty Strings: Check if a list of strings contains only empty strings.
        System.out.println(
                List.of("ant","apple","ant","")
                        .stream()
                        .anyMatch(String::isEmpty)
        );

        //Stream Iteration and Limiting: Create a stream of integers from 1 to 100 and print the first 10.
        IntStream.range(1,100)
                .limit(10)
                .forEach(System.out::println);

        //Check for Equal Lists: Check if two lists are equal irrespective of element order.

        System.out.println(
                List.of(1,2,3)
                        .stream()
                        .sorted()
                        .collect(Collectors.toList()).equals(Stream.of(2,3,1).sorted().toList())
        );

        //FlatMapping Nested Lists: Flatten a list of lists into a single list.

        System.out.println(
                List.of(List.of(1,2,3,4),List.of(5,6,7),List.of(8,9),List.of(10))
                        .stream()
                        .flatMap(list -> list.stream())
                        .collect(Collectors.toList())
        );

        /*//Creating Infinite Streams: Generate an infinite stream of even numbers.
        IntStream.iterate(0,number -> number+2)
                .forEach(System.out::println);

        //generate infinite stream
        IntStream.generate(() -> 1)
                .forEach(System.out::println);
        */
        //Trimming Strings: Trim all strings in a list.
        System.out.println(
                List.of("sasi ","ant ","apple  ","  orange  ")
                        .stream()
                        .map(String::trim)
                        .collect(Collectors.toList())
        );

        //Creating Stream from Array: Create a stream from an array of integers and find the sum.
        System.out.println(
                Arrays.stream(new int[] {1,2,3,4,5})
                        .sum()
        );

        //Finding Median of Numbers: Find the median of a list of numbers.
        System.out.println(
                List.of(1,2,3,4,5)
                        .stream()
                        .sorted()
                        .skip((List.of(1,2,3,4,5).size()-1)/2)
                        .limit( List.of(1,2,3,4,5).size()%2==0 ? 2 : 1)
                        .collect(Collectors.averagingDouble(a->a))
        );

        // Check for Divisibility: Check if all elements in a list are divisible by a given number.
        System.out.println(
                List.of(1,2,3,4,5)
                        .stream().allMatch(number -> number % 2 == 0)
        );

        //Removing Null Values: Remove null values from a list of strings.
        List.of("ant","apple","orange","")
                .stream()
                .filter(Predicate.not(String::isEmpty))
                .forEach(System.out::println);

        //Skipping Elements: Skip the first 5 elements of a stream and print the rest.
        List.of(1,2,3,4,5,6,7,8,9,10)
                .stream()
                .skip(5)
                .forEach(System.out::println);

        //Find Common Elements: Find common elements between two lists.
        System.out.println(new ArrayList<>(List.of(1,2,3,4)).retainAll(new ArrayList<>(List.of(2,3))));
        System.out.println(
                List.of(1,2,3).stream()
                        .filter(element -> List.of(2,3,4).contains(element))
                        .collect(Collectors.toList())
        );

        // Sum of List Elements: Calculate the sum of elements in a list.
        System.out.println(
                List.of(1,2,3)
                        .stream()
                        .mapToInt(Integer::intValue)
                        .sum()
        );

        System.out.println(

                List.of(1,2,3)
                        .stream()
                        .collect(Collectors.summingInt(Integer::intValue))
        );

        //Find Most Common Element: Find the most common element in a list.
        System.out.println(
                List.of(1,1,2,2,3,3,3,3,4,4,4,4,5,5,5,5,5,5,5,9)
                        .stream()
                        .collect(Collectors.groupingBy(a -> a,Collectors.counting()))
                        .entrySet()
                        .stream()
                        .collect(Collectors.maxBy(Map.Entry.comparingByValue())).get()
                        .getKey()
        );

        System.out.println(
                List.of(1,2,3,4).stream()
                        .collect(Collectors.summarizingDouble(Integer::intValue))
        );

        //Grouping by Multiple Criteria: Group a list of objects by multiple criteria.
        System.out.println(
                List.of(new Person("Vamsi",20),new Person("sasi",20),new Person("siddu",22),new Person("sreeja",21),new Person("lavanya",22))
                        .stream()
                        .collect(Collectors.groupingBy(Person::getAge,Collectors.groupingBy(Person::getName)))
        );

        //Collecting and Merging Maps: Collect multiple maps into a single map.
        System.out.println(
                Stream.concat(Map.of("sasi",1).entrySet().stream(),Map.of("sasi",2).entrySet().stream())
                        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(value01,value02) -> value02))
        );
        //List.of().subList();

        //print odd numbers using predicate not
        Predicate<Integer> evenNumber = number -> number % 2 == 0;

        List.of(1,2,3,4,5)
                .stream()
                .filter(Predicate.not(evenNumber))
                .forEach(System.out::println);

    }


    public static boolean isPrime(int number) {
        int count=0;
        for(int i=2;i<Math.sqrt(number);i++) {
            if(number % i == 0) {
                count+=1;
            }
        }
        return count == 0;
    }

    public static boolean isPalindrome(String word) {
        StringBuilder stringBuilder = new StringBuilder(word);
        String reverseWord = stringBuilder.reverse().toString();
        return word.equals(reverseWord);
    }

}

class A<T> implements Collector<T,List<T>,T> {

    @Override
    public Supplier<List<T>> supplier() {
        return null;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return null;
    }

    @Override
    public BinaryOperator<List<T>> combiner() {
        return null;
    }

    @Override
    public Function<List<T>, T> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}