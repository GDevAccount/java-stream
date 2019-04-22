# java-stream

Stream is a new abstract layer introduced in Java 8. Using stream, you can process data in a declarative way similar to SQL statements.

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

Those functions accepts a Comparator in parameter

```
Optional<T> min(Comparator<? super T> comparator)
```

Example:

```
Comparator<Employee> comparator = Comparator.comparing( Employee::getAge );
Employee minObject = employees.stream().min(comparator).get();
```

[Link to more statistics examples](https://github.com/GDevAccount/java-stream/blob/master/src/test/java/examples/Statistics.java)
