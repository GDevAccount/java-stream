package examples;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import beans.Car;
import beans.Person;
import beans.PersonDTO;
import mockdata.MockData;

public class Mapping {


  @Test
  public void classicMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

    List<PersonDTO> dtos = people.stream().map(PersonDTO::map).collect(Collectors.toList());

    assertThat(dtos).hasSize(1000);

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    double average = MockData.getCars().stream().mapToDouble(Car::getPrice).average().orElse(0);

  }

  @Test
  public void toUpperCase() throws Exception {
    // calculate average of car prices
    List<String> models = MockData.getCars().stream().map(car -> {
      return car.getModel();
    }).distinct().map(String::toUpperCase).collect(Collectors.toList());

    models.forEach(System.out::println);

  }

  @Test
  public void mappingAndFilter() throws Exception {
    System.out.println(MockData.getCars().stream().filter(car -> {
      // System.out.println("filter car " + car);
      return car.getPrice() < 10000;
    }).map(car -> {
      // System.out.println("mapping car " + car);
      return car.getPrice();
    }).map(price -> {
      // System.out.println("mapping price " + price);
      return price + (price * .14);
    }).collect(Collectors.toList()));
  }

}
