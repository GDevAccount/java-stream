# java-stream

Stream is a new abstract layer introduced in Java 8. Using stream, you can process data in a declarative way similar to SQL statements.

![Schema](https://github.com/GDevAccount/java-stream/blob/master/stream.png)

![Schema2](https://github.com/GDevAccount/java-stream/blob/master/stream2.png)

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
Stream<T> distinct();
```

Example:

```
List<String> staffNames = staff.stream().map(x -> x.getName()).collect(Collectors.toList());
```

[Link to more Distinct examples](https://github.com/GDevAccount/java-stream/blob/master/src/test/java/examples/Distinct.java)

