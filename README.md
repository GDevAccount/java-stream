# java-stream

Stream is a new abstract layer introduced in Java 8. Using stream, you can process data in a declarative way similar to SQL statements.

First, we obtain a stream from the list of transactions (the data) using the stream() method available on List. Next, several operations (filter, sorted, map, collect) are chained together to form a pipeline, which can be seen as forming a query on the data.


<img src="https://github.com/GDevAccount/java-stream/blob/master/stream.png" title="Schema 1" alt="Schema 1">

##### Predicate 

In Java 8, Predicate is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference. 

```
public static Predicate<Employee> isAdultFemale() {
    return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
}
 
Predicate<Car> carPredicate = car -> car.getPrice() < 10000;
```

* Predicates move your conditions (sometimes business logic) to a central place. This helps in unit-testing them separately.
* Any change need not be duplicated into multiple places. Java predicate improves code maintenance.
* The code e.g. “filterEmployees(employees, isAdultFemale())” is very much readable than writing a if-else block.


##### Comparator 

The Comparator interface defines a compare(arg1, arg2) method with two arguments which represent compared objects and works similarly to the Comparable.compareTo() method.


```
public class PlayerAgeComparator implements Comparator<Player> {
    @Override
    public int compare(Player firstPlayer, Player secondPlayer) {
       return (firstPlayer.getAge() - secondPlayer.getAge());
    }
}

//Comparator with lambda function :
Comparator<Player> byRanking = (Player player1, Player player2) -> player1.getRanking() - player2.getRanking();
```

The implementation of the compare() method should return

* a negative integer, if the first argument is less than the second,
* zero, if the first argument is equal to the second, and
* a positive integer, if the first argument is greater than the second.

<a href="http://fvcproductions.com"><img src="https://github.com/GDevAccount/java-stream/blob/master/stream2.png" title="Schema 2" alt="Schema 2"></a>

----
## Filter

The filter() method is an intermediate operation of the Stream interface that allows us to filter elements of a stream that match a given Predicate:

```
Stream<T> filter(Predicate<? super T> predicate)
```

Example:

```
List<Customer> customersWithMoreThan100Points = customers
  .stream()
  .filter(c -> c.getPoints() > 100)
  .collect(Collectors.toList());
```

[Link to more filter examples](https://github.com/GDevAccount/java-stream/blob/master/src/test/java/examples/Filter.java)

----
## Statistics

Learn to find min and max, sum, count and average


```
Optional<T> min(Comparator<? super T> comparator)
Optional<T> max(Comparator<? super T> comparator)
long count()
OptionalDouble average()
```

Example:

```
Comparator<Employee> comparator = Comparator.comparing( Employee::getAge );
Employee minObject = employees.stream().min(comparator).get();
```

[Link to more statistics examples](https://github.com/GDevAccount/java-stream/blob/master/src/test/java/examples/Statistics.java)

----
## Distinct

The Stream API provides the distinct() method that returns different elements of a list based on the equals() method of the Object class.

```
Stream<T> distinct();
```

Example:

```
List<String> distinctElements = list.stream().distinct().collect(Collectors.toList());
```

[Link to more Distinct examples](https://github.com/GDevAccount/java-stream/blob/master/src/test/java/examples/Distinct.java)

----
## Mapping

stream().map() lets you convert an object to something else.

```
<R> Stream<R> map(Function<? super T,? extends R> mapper)
DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)
```

Example:

```
List<String> staffNames = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
```

[Link to more Mapping examples](https://github.com/GDevAccount/java-stream/blob/master/src/test/java/examples/Mapping.java)

----
## Mapping

stream().map() lets you convert an object to something else.

```
<R> Stream<R> map(Function<? super T,? extends R> mapper)
DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper)
```

Example:

```
List<String> staffNames = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
```

[Link to more Distinct examples](https://github.com/GDevAccount/java-stream/blob/master/src/test/java/examples/Mapping.java)
