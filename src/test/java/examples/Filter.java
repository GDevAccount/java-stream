package examples;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.Test;
import beans.Car;
import beans.Person;
import mockdata.MockData;

public class Filter {

  @Test
  public void exampleClassic() throws Exception {
    List<Car> cars = MockData.getCars();

    List<Car> carsFiltered =
        cars.stream().filter(car -> car.getPrice() < 10000).collect(Collectors.toList());

    assertThat(carsFiltered.size()).isEqualTo(57);
  }


  @Test
  public void exampleWithExternalPredicate() throws Exception {
    List<Car> cars = MockData.getCars();
    Predicate<Car> carPredicate = car -> car.getPrice() < 10000;

    List<Car> carsFiltered = cars.stream().filter(carPredicate).collect(Collectors.toList());

    assertThat(carsFiltered.size()).isEqualTo(57);
  }

  @Test
  public void exampleWithLimit() throws Exception {
    List<Person> people = MockData.getPeople();

    List<Person> youngPeople = people.stream().filter(person -> person.getAge() <= 18).limit(10)
        .collect(Collectors.toList());

    assertThat(youngPeople.size()).isEqualTo(10);
  }

  @Test
  public void exampleFindAny() {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;
    int any = Arrays.stream(numbers).filter(numbersLessThan10).findAny().get();

    assertThat(any).isGreaterThan(5).isLessThan(10);
  }


}
