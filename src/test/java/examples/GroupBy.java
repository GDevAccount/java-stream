package examples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.assertj.core.util.Lists;
import org.junit.Test;
import beans.Car;
import mockdata.MockData;

public class GroupBy {

  @Test
  public void simpleGrouping() throws Exception {
    Map<String, List<Car>> grouping =
        MockData.getCars().stream().collect(Collectors.groupingBy(Car::getMake));

    grouping.forEach((make, cars) -> {
      // System.out.println(make);
      // cars.forEach(System.out::println);
    });
  }

  @Test
  public void groupingAndCounting() throws Exception {
    ArrayList<String> names = Lists.newArrayList("John", "John", "Mariam", "Alex", "Mohammado",
        "Mohammado", "Vincent", "Alex", "Alex");

    Map<String, Long> counting =
        names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    counting.forEach((name, count) -> System.out.println(name + " > " + count));
  }


}
